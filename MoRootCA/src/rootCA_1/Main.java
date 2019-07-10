package rootCA_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String moRootDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_MO_RootCA, DC=V2G";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {
		System.out.println("server thread start");
		server.serverRun(5001);
		boolean isConnected = true;
		while (isConnected) {
			try {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getCertList(0);
						// create mo_subCA1_cert
						sUtils.generateSubCa1Certificate(moRootDn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName, 24);
						// send cert to subCA1
						List<String> certName = new ArrayList<>();
						certName.add(subjectCertName);// subCA1Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certName);
						server.sendPacket(sendData);
					} else if (type.equals("ReqToGetMORootCert")) {
						// send MORootCert
						String certName = Main.getCertList(0).getCertName();
						List<String> certNameList = new ArrayList<>();
						certNameList.add(certName);
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
						System.out.println("send MoRootCert finish");
					} else if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(5001);
						System.out.println("finish the connection");
						System.out.println("MO rootCA===================================");
						System.out.println("1. issue rootCA certificate\n2. request to get V2G Root certificate");
					}
				}
			} catch (Exception e) {
			}
		}

	}
}

public class Main {
	private static List<CertData> moRootCertList = new ArrayList();

	public static CertData getCertList(int index) {
		return new CertData(moRootCertList.get(index));
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
		String moRootDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_MO_RootCA, DC=V2G";

		String crlFileName = "mo_rootCA_CRL.pem";

		while (mainFlag == 1) {
			System.out.println("MO rootCA===================================");
			System.out.println("1. issue rootCA certificate\n2. request to get V2G Root certificate");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				// create private key. pem, public key.pem
				String moRootPrivateFileName = "mo_root_private_" + rootCertCount + ".pem";
				String moRootPublicFileName = "mo_root_public_" + rootCertCount + ".pem";
				sUtils.generateEcKeyPair(moRootPrivateFileName, moRootPublicFileName);

				// create mo_rootCA_csr
				String csrFileName = "mo_rootCA_csr.pem";
				sUtils.generateCsr(moRootPrivateFileName, moRootPublicFileName, moRootDn, csrFileName);

				// create mo_rootCA_cert
				String moRootCertName = "mo_rootCA_cert_" + rootCertCount + ".pem";
				sUtils.generateRootCertificate(csrFileName, moRootDn, moRootPrivateFileName, moRootPublicFileName, moRootCertName, 24);
				moRootCertList.add(new CertData(moRootCertName, moRootPrivateFileName, moRootPublicFileName));
				rootCertCount++;

			} else if (inputValue == 2) {
				client.clientRun(1001);
				boolean isConnected = true;
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
			} else if (inputValue == 99) {

			} else {

			}
		}

		sc.close();

	}

}
