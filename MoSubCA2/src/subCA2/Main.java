package subCA2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String moSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_MO_SubCA2, DC=V2G";
	String moSub2PrivateFileName = "mo_sub2_private.pem";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(5003);
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getsubCA2CertList(0);
						// create mo_contract_cert
						sUtils.generateLeafCertificate(moSubCa2Dn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName, 12);
						// send cert to RA
						List<String> certNameList = new ArrayList<>();
						certNameList.add(subjectCertName);// Contract cert
						certNameList.add(certData.getCertName());// subCA2Cert
						certNameList.add(certData.getSubCa1CertName());// subCA1Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
					} else if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(5003);
						System.out.println("finish the connection");
						System.out.println(
								"MO SubCA2=======================================================================================");
						System.out.println(
								"1. request to get MO Root certificate\n2. request subCA2 certificate\n");
					}
				}
			}
		} catch (Exception e) {
		}

	}
}

public class Main {

	private static List<CertData> subCA2CertList = new ArrayList<>();

	public static CertData getsubCA2CertList(int index) {
		return new CertData(subCA2CertList.get(index));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();
		ServerThread st = new ServerThread();
		st.start();

		int mainFlag = 1;
		int sub2CertCount = 0;
		String rootCertName = null;

		String moSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_MO_SubCA2, DC=V2G";
		String moSub2PrivateFileName = "mo_sub2_private_" + sub2CertCount + ".pem";

		String crlFileName = "mo_subCA2_CRL.pem";
		String moSub2FirstCertName = "mo_subCA2_cert.pem";
		String moSub2FirstPrivateFileName = "mo_sub2_private.pem";

		while (mainFlag == 1) {
			System.out.println(
					"MO SubCA2=======================================================================================");
			System.out.println(
					"1. request to get MO Root certificate\n2. request subCA2 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(5001);
				boolean isConnected = true;
				// request to get mo Root certificate
				byte[] sendData = sUtils.makeReqToGetMORootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to MOrootCA");
				while (isConnected) {

					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : MO Root Cert Name
							rootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					}
				}
			} else if (inputValue == 2) {
				client.clientRun(5002);
				boolean isConnected = true;
				// create private key.pem
				String moSub2PublicFileName = "mo_sub2_public_" + sub2CertCount + ".pem";
				sUtils.generateEcKeyPair(moSub2PrivateFileName, moSub2PublicFileName);
				// create mo_subCA2_csr
				String csrFileName = "mo_subCA2_csr.pem";
				sUtils.generateCsr(moSub2PrivateFileName, moSub2PublicFileName, moSubCa2Dn, csrFileName);
				// send csr to subCA1
				String moSub2CertName = "mo_subCA2_cert_" + sub2CertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, moSub2CertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to subCA1");
				while(isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : subCA2CertName, saveCertList(1) : subCA1CertName
							subCA2CertList.add(
									new CertData(moSub2CertName, moSub2PrivateFileName, moSub2PublicFileName, saveCertList.get(1), rootCertName));
							System.out.println(subCA2CertList.get(0).getSubCa1CertName());
							sub2CertCount++;
							System.out.println("save cert in pem file");
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with Sub CA1");
						}
					}
				}
				
			} else if (inputValue == 4) {

			}
		}
	}
}
