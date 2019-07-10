package kr.ac.hmcl.mju.CpsSubCA1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String cpsSubCa1Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPS_SubCA1, DC=V2G";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(1002);
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getSubCA1CertList(0);
						// create cps_sub2_cert
						sUtils.generateSubCa2Certificate(cpsSubCa1Dn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName, 3);
						// send cert to cps subCA2
						List<String> certNameList = new ArrayList<>();
						certNameList.add(subjectCertName);//cps subca2 cert
						certNameList.add(certData.getCertName());//subca1 cert
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
					}else if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(1002);
						System.out.println("finish the connection");
					}
				}
			}
		} catch (Exception e) {
		}

	}
}

public class Main {

	private static List<CertData> subCA1CertList = new ArrayList<>();

	public static CertData getSubCA1CertList(int index) {
		return new CertData(subCA1CertList.get(index));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();
		ServerThread st = new ServerThread();
		st.start();

		int mainFlag = 1;
		int sub1CertCount = 0;
		String rootCertName = null;
		
		String cpsSubCa1Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPS_SubCA1, DC=V2G";
		String cpsSub1PrivateFileName = "cps_sub1_private_" + sub1CertCount + ".pem";

		String crlFileName = "cps_subCA1_CRL.pem";

		while (mainFlag == 1) {
			System.out.println("cps SubCA1");
			System.out.println("1. request to get v2g Root certificate\n2. request subCA1 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(1001);
				boolean isConnected = true;
				// request to get v2g Root certificate
				byte[] sendData = sUtils.makeReqToGetV2GRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to v2g rootCA");
				while (isConnected) {

					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : v2g Root Cert Name
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
				// TCP connect with V2GRootCA
				client.clientRun(1001);
				boolean isConnected = true;
				// create private key.pem
				String cpsSub1PublicFileName = "cps_sub1_public_" + sub1CertCount + ".pem";
				sUtils.generateEcKeyPair(cpsSub1PrivateFileName, cpsSub1PublicFileName);
				// create cps_subCA1_csr
				String csrFileName = "cps_subCA1_csr.pem";
				sUtils.generateCsr(cpsSub1PrivateFileName, cpsSub1PublicFileName, cpsSubCa1Dn, csrFileName);
				// send csr to RootCA
				String cpsSub1CertName = "cps_subCA1_cert_" + sub1CertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, cpsSub1CertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to rootCA");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : subCa1CertName
							subCA1CertList
									.add(new CertData(cpsSub1CertName, cpsSub1PrivateFileName, cpsSub1PublicFileName, rootCertName));
							sub1CertCount++;
							System.out.println("save cert in pem file");//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					}
				}
			}
		}
	}
}
