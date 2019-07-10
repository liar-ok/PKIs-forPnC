package kr.ac.hmcl.mju.V2G_2_RootCA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String v2gRootDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_V2G-2_RootCA, DC=V2G";

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {
		System.out.println("server thread start");
		server.serverRun(21001);
		while (true) {
			try {				
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					System.out.println("MSG type is :" + type);					
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						// create cps subCA1_cert
						String privateFileName = Main.getCertList(0).getPrivateFileName();
						String publicFileName = Main.getCertList(0).getPublicFileName();
						sUtils.generateSubCa1Certificate(v2gRootDn, privateFileName, publicFileName, subjectCertName,4*12);
						// send cert to subCA1
						List<String> certNameList = new ArrayList<>();
						certNameList.add(subjectCertName);//subCA1Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
					}else if(type.equals("ReqToGetV2GRootCert")) {
						//send v2gRootCert
						String certName = Main.getCertList(0).getCertName();
						List<String> certNameList = new ArrayList<>();
						certNameList.add(certName);
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
						System.out.println("send v2gRootCert finish");
					}else if(type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(21001);
						System.out.println("finish the connection");
					}else if(type.equals("ReqToGetV2GCrossRootCert")) {
						//send v2gCrossRootCert
						String certName = Main.getCrossCertList(0).getCertName();
						List<String> certNameList = new ArrayList<>();
						certNameList.add(certName);
						byte[] sendData = sUtils.makeResWithCertMsg(certNameList);
						server.sendPacket(sendData);
						System.out.println("send v2gRootCert finish");
					}
				}
			} catch (Exception e) {
			}
		}
	}
}

public class Main {
	
	private static List<CertData> v2gCertList = new ArrayList();
	public static CertData getCertList(int index) {
		return new CertData(v2gCertList.get(index));
	}
	private static List<CrossCertData> crossCertList = new ArrayList<CrossCertData>();
	public static CrossCertData getCrossCertList(int index) {
		return new CrossCertData(crossCertList.get(index));
	}
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();
		ServerThread st = new ServerThread();
		st.start();

		int mainFlag = 1;

		int rootCertCount = 0;
		
		String v2gRootDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_V2G-2_RootCA, DC=V2G";

		
		while (mainFlag == 1) {
			System.out.println("V2G-2 rootCA");
			System.out.println("1. issue V2G-2 rootCA certificate\n2. request Cross Root Certificate");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				// create private key. pem, public key.pem
				String v2gRootPrivateFileName = "v2g-2_root_private_" + rootCertCount + ".pem";
				String v2gRootPublicFileName = "v2g-2_root_public_" + rootCertCount + ".pem";
				sUtils.generateEcKeyPair(v2gRootPrivateFileName, v2gRootPublicFileName);

				// create v2g_rootCA_csr
				String csrFileName = "v2g-2_rootCA_csr.pem";
				sUtils.generateCsr(v2gRootPrivateFileName, v2gRootPublicFileName, v2gRootDn, csrFileName);

				// create v2g_rootCA_cert
				String v2gRootCertName = "v2g-2_rootCA_cert_" + rootCertCount + ".pem";
				sUtils.generateRootCertificate(csrFileName, v2gRootDn, v2gRootPrivateFileName, v2gRootPublicFileName,v2gRootCertName, 40*12);
				v2gCertList.add(new CertData(v2gRootCertName, v2gRootPrivateFileName, v2gRootPublicFileName));
				rootCertCount++;

			}else if(inputValue == 2) {
				//request cross root certificate
				// TCP connect with V2GRootCA
				client.clientRun(1001);
				boolean isConnected = true;
				// create v2g-2_cross_root_csr
				String csrFileName = "v2g-2_cross_root_csr.pem";
				String v2gRootPrivateFileName = v2gCertList.get(0).getPrivateFileName();
				String v2gRootPublicFileName = v2gCertList.get(0).getPublicFileName();
				sUtils.generateCsr(v2gRootPrivateFileName, v2gRootPublicFileName, v2gRootDn, csrFileName);
				// send csr to v2g RootCA
				String v2gCrossRootCertName = "v2g-2_cross_root_cert.pem";
				byte[] sendData = sUtils.makeReqToIssueCrossCertMsg(csrFileName, v2gCrossRootCertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to v2g rootCA");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : cross Root CertName
							crossCertList
									.add(new CrossCertData(v2gCrossRootCertName, v2gRootPrivateFileName, v2gRootPublicFileName, v2gCertList.get(0).getCertName()));
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

		sc.close();

	
	}

}
