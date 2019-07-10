package rootCA_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String oemRootDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_OEM_RootCA, DC=V2G";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {
		System.out.println("server thread start");
		server.serverRun(2001);
		boolean isConnected = true;
		while (isConnected) {
			try {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getCertList(0);
						// create oem_subCA1_cert
						sUtils.generateSubCa1Certificate(oemRootDn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName, 24);
						// send cert to subCA1
						List<String> certName = new ArrayList<>();
						certName.add(subjectCertName);//subCA1Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certName);
						server.sendPacket(sendData);
					}else if(type.equals("ReqToGetOEMRootCert")) {
						//send OEMRootCert
						String certName = Main.getCertList(0).getCertName();
						List<String> certNameList = new ArrayList<>();
						certNameList.add(certName);
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
						System.out.println("send OEMRootCert finish");
					}else if(type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(2001);
						System.out.println("finish the connection");
						System.out.println("OEM rootCA==============================================");
						System.out.println(
								"1. issue rootCA certificate\n2. request to get V2G Root certificate");
					}
				}
			} catch (Exception e) {
			}
		}
		
	}
}

public class Main {
	private static List<CertData> oemRootCertList = new ArrayList();
	public static CertData getCertList(int index) {
		return new CertData(oemRootCertList.get(index));
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();
		ServerThread st = new ServerThread();
		st.start();
		

		int mainFlag = 1;

		int rootCertCount = 0;
		List<String> receivedCertList = new ArrayList();


		String oemRootDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_OEM_RootCA, DC=V2G";

		String crlFileName = "oem_rootCA_CRL.pem";

		while (mainFlag == 1) {
			System.out.println("OEM rootCA==============================================");
			System.out.println(
					"1. issue rootCA certificate\n2. request to get V2G Root certificate");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				// create private key. pem, public key.pem
				String oemRootPrivateFileName = "oem_root_private_" + rootCertCount + ".pem";
				String oemRootPublicFileName = "oem_root_public_" + rootCertCount + ".pem";
				sUtils.generateEcKeyPair(oemRootPrivateFileName, oemRootPublicFileName);

				// create oem_rootCA_csr
				String csrFileName = "oem_rootCA_csr.pem";
				sUtils.generateCsr(oemRootPrivateFileName, oemRootPublicFileName, oemRootDn, csrFileName);

				// create oem_rootCA_cert
				String oemRootCertName = "oem_rootCA_cert_" + rootCertCount + ".pem";
				sUtils.generateRootCertificate(csrFileName, oemRootDn, oemRootPrivateFileName, oemRootPublicFileName, oemRootCertName, 24);
				oemRootCertList.add(new CertData(oemRootCertName, oemRootPrivateFileName,oemRootPublicFileName));
				rootCertCount++;

			} else if (inputValue == 2) {
				client.clientRun(1001);
				boolean isConnected = true;
				byte[] sendData = sUtils.makeReqToGetV2GRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to V2GrootCA");
				while(isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : v2g Root Cert Name
							receivedCertList.add(saveCertList.get(0));
							System.out.println("save cert in pem file");
							System.out.println("----> received " + receivedCertList.get(0));// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with v2g root CA");
						}
					}
				}
			}else if(inputValue == 3) {
				
				
			}else {

			}
		}

		sc.close();

	}

}
