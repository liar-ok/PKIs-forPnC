package subCA1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String cpoSubCa1Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPO_SubCA1, DC=V2G";


	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(1012);
			while(true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						// create cpo_subCA2_cert
						CertData certData = Main.getCertList(0);
						sUtils.generateSubCa2Certificate(cpoSubCa1Dn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName,24);
						// send cert to subCA2
						List<String> certName = new ArrayList<>();
						certName.add(subjectCertName); //subCA2 cert
						certName.add(certData.getCertName());//subCA1 Cert
						byte[] sendData = sUtils.makeResWithCertMsg(certName);
						server.sendPacket(sendData);
					}else if(type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(1012);
						System.out.println("finish the connection");
					}
				}
			}
		} catch (Exception e) {
		}

	}
}

public class Main {
	
	private static List<CertData> myCertList = new ArrayList();
	public static CertData getCertList(int index) {
		return new CertData((CertData)myCertList.get(index));
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
		
		String cpoSubCa1Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPO_SubCA1, DC=V2G";
		String cpoSub1PrivateFileName = "cpo_sub1_private_"+sub1CertCount+".pem";
		
		String crlFileName = "cpo_subCA1_CRL.pem";

		while (mainFlag == 1) {
			System.out.println("CPO SubCA1=======================================================================================");
			System.out.println("1. request to get V2G Root certificate\n2. request subCA1 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				//request to get V2G Root certificate
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
							// saveCertList(0) : V2G Root Cert Name
							rootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					}else {
						isConnected = false;
					}
				}
				
				
			} else if (inputValue == 2) {
				client.clientRun(1001);
				boolean isConnected = true;
				// create private key.pem
				String cpoSub1PublicFileName = "cpo_sub1_public_"+sub1CertCount+".pem";
				sUtils.generateEcKeyPair(cpoSub1PrivateFileName, cpoSub1PublicFileName);
				// create cpo_subCA1_csr
				String csrFileName = "cpo_subCA1_csr.pem";
				sUtils.generateCsr(cpoSub1PrivateFileName, cpoSub1PublicFileName, cpoSubCa1Dn, csrFileName);
				// send csr to RootCA
				String cpoSub1CertName = "cpo_subCA1_cert_"+sub1CertCount+".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, cpoSub1CertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to rootCA");
				while(isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : subCA1CertName
							myCertList.add(new CertData(cpoSub1CertName,cpoSub1PrivateFileName,cpoSub1PublicFileName,rootCertName));
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
				
			} else if (inputValue == 4) {
				
			} else {
				
			}
		}
	}
}
