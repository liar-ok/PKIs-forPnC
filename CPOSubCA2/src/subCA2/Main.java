package subCA2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String cpoSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPO_SubCA2, DC=V2G";
	String cpoSub2PrivateFileName = "cpo_sub2_private.pem";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(1013);
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getsubCA2CertList(0);
						// create cpo_leaf_cert
						sUtils.generateLeafCertificate(cpoSubCa2Dn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName, 3);
						// send cert to RA
						List<String> certNameList = new ArrayList<>();
						certNameList.add(subjectCertName);// Leaf cert
						certNameList.add(certData.getCertName());// subCA2Cert
						certNameList.add(certData.getSubCa1CertName());// subCA1Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
					} else if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(1013);
						System.out.println("finish the connection");
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

		String cpoSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPO_SubCA2, DC=V2G";
		String cpoSub2PrivateFileName = "cpo_sub2_private_" + sub2CertCount + ".pem";

		String crlFileName = "cpo_subCA2_CRL.pem";
		String cpoSub2FirstCertName = "cpo_subCA2_cert.pem";
		String cpoSub2FirstPrivateFileName = "cpo_sub2_private.pem";

		while (mainFlag == 1) {
			System.out.println(
					"CPO SubCA2=======================================================================================");
			System.out.println(
					"1. request to get V2G Root certificate\n2. request subCA2 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(1001);
				boolean isConnected = true;
				// request to get v2g Root certificate
				byte[] sendData = sUtils.makeReqToGetV2GRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to V2GrootCA");
				while (isConnected) {

					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : V2G Root Cert Name
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
				client.clientRun(1012);
				boolean isConnected = true;
				// create private key.pem
				String cpoSub2PublicFileName = "cpo_sub2_public_" + sub2CertCount + ".pem";
				sUtils.generateEcKeyPair(cpoSub2PrivateFileName, cpoSub2PublicFileName);
				// create cpo_subCA2_csr
				String csrFileName = "cpo_subCA2_csr.pem";
				sUtils.generateCsr(cpoSub2PrivateFileName, cpoSub2PublicFileName, cpoSubCa2Dn, csrFileName);
				// send csr to subCA1
				String cpoSub2CertName = "cpo_subCA2_cert_" + sub2CertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, cpoSub2CertName);
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
									new CertData(cpoSub2CertName, cpoSub2PrivateFileName, cpoSub2PublicFileName, saveCertList.get(1), rootCertName));
							System.out.println(subCA2CertList.get(0).getSubCa1CertName());
							sub2CertCount++;
							System.out.println("save cert in pem file");
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					}
				}
				
			} else if (inputValue == 4) {

			}
		}
	}
}
