package subCA2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String oemSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_OEM_SubCA2, DC=V2G";
	String oemSub2PrivateFileName = "oem_sub2_private.pem";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(2003);
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getsubCA2CertList(0);
						// create oem_contract_cert
						sUtils.generateLeafCertificate(oemSubCa2Dn, certData.getPrivateFileName(),certData.getPublicFileName(), subjectCertName, 12);
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
						server.serverRun(2003);
						System.out.println("finish the connection");
						System.out.println(
								"OEM SubCA2=======================================================================================");
						System.out.println(
								"1. request to get OEM Root certificate\n2. request subCA2 certificate\n");
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

		String oemSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_OEM_SubCA2, DC=V2G";
		String oemSub2PrivateFileName = "oem_sub2_private_" + sub2CertCount + ".pem";

		while (mainFlag == 1) {
			System.out.println(
					"OEM SubCA2=======================================================================================");
			System.out.println(
					"1. request to get OEM Root certificate\n2. request subCA2 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(2001);
				boolean isConnected = true;
				// request to get oem Root certificate
				byte[] sendData = sUtils.makeReqToGetOEMRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to OEMrootCA");
				while (isConnected) {

					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : OEM Root Cert Name
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
				client.clientRun(2002);
				boolean isConnected = true;
				// create private key.pem
				String oemSub2PublicFileName = "oem_sub2_public_" + sub2CertCount + ".pem";
				sUtils.generateEcKeyPair(oemSub2PrivateFileName, oemSub2PublicFileName);
				// create oem_subCA2_csr
				String csrFileName = "oem_subCA2_csr.pem";
				sUtils.generateCsr(oemSub2PrivateFileName, oemSub2PublicFileName, oemSubCa2Dn, csrFileName);
				// send csr to subCA1
				String oemSub2CertName = "oem_subCA2_cert_" + sub2CertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, oemSub2CertName);
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
									new CertData(oemSub2CertName, oemSub2PrivateFileName, oemSub2PublicFileName, saveCertList.get(1), rootCertName));
							System.out.println(subCA2CertList.get(0).getSubCa1CertName());
							sub2CertCount++;
							System.out.println("save cert in pem file");
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with subCA1");
						}
					}
				}
				
			} else if (inputValue == 4) {

			}
		}
	}
}
