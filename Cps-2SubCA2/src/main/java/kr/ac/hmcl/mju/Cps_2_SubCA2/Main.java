package kr.ac.hmcl.mju.Cps_2_SubCA2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String cpsSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPS-2_SubCA2, DC=V2G";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(21003);
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						CertData certData = Main.getSubCA2CertList(0);
						// create cps_leaf_cert
						sUtils.generateLeafCertificate(cpsSubCa2Dn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName, 3);
						// send cert to cps RA
						List<String> certNameList = new ArrayList<>();
						certNameList.add(subjectCertName);//cps leaf cert
						certNameList.add(certData.getCertName());//subca2 cert
						certNameList.add(certData.getSubCa1CertName());//subca1 Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
					}else if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(21003);
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

	public static CertData getSubCA2CertList(int index) {
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
		
		String cpsSubCa2Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPS-2_SubCA2, DC=V2G";
		String cpsSub2PrivateFileName = "cps-2_sub1_private_" + sub2CertCount + ".pem";

		

		while (mainFlag == 1) {
			System.out.println("cps-2 SubCA2");
			System.out.println("1. request to get v2g Root certificate\n2. request subCA2 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(21001);
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
				// TCP connect with CPS subCA1
				client.clientRun(21002);
				boolean isConnected = true;
				// create private key.pem
				String cpsSub2PublicFileName = "cps-2_sub2_public_" + sub2CertCount + ".pem";
				sUtils.generateEcKeyPair(cpsSub2PrivateFileName, cpsSub2PublicFileName);
				// create cps_subCA2_csr
				String csrFileName = "cps-2_subCA2_csr.pem";
				sUtils.generateCsr(cpsSub2PrivateFileName, cpsSub2PublicFileName, cpsSubCa2Dn, csrFileName);
				// send csr to CPS SubCA1
				String cpsSub2CertName = "cps-2_subCA2_cert_" + sub2CertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, cpsSub2CertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to CPS-2 SubCA1");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(1) : subCa1CertName
							subCA2CertList
									.add(new CertData(cpsSub2CertName, cpsSub2PrivateFileName, cpsSub2PublicFileName, saveCertList.get(1), rootCertName));
							sub2CertCount++;
							System.out.println("save cert in pem file");//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with CPS-2 SubCA1");
						}
					}
				}
			}
		}
	}
}
