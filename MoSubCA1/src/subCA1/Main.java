package subCA1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	String moSubCa1Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_MO_SubCA1, DC=V2G";


	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(5002);
			while(true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("ReqToIssueCertFormat")) {
						String subjectCertName = sUtils.prepareToIssueCert(getData);
						// create mo_subCA2_cert
						CertData certData = Main.getCertList(0);
						sUtils.generateSubCa2Certificate(moSubCa1Dn, certData.getPrivateFileName(), certData.getPublicFileName(), subjectCertName,24);
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
						server.serverRun(5002);
						System.out.println("finish the connection");
						System.out.println("MO SubCA1=======================================================================================");
						System.out.println("1. request to get MO Root certificate\n2. request subCA1 certificate\n");
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
		

		String moSubCa1Dn = "C=KR, O=MJU, OU=HMCL, CN=MJU_MO_SubCA1, DC=V2G";
		String moSub1PrivateFileName = "mo_sub1_private_"+sub1CertCount+".pem";
		
		String crlFileName = "mo_subCA1_CRL.pem";

		while (mainFlag == 1) {
			System.out.println("MO SubCA1=======================================================================================");
			System.out.println("1. request to get MO Root certificate\n2. request subCA1 certificate\n");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				//request to get mo Root certificate
				client.clientRun(5001);
				boolean isConnected = true;
				byte[] sendData = sUtils.makeReqToGetMORootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to MOrootCA");
				while(isConnected) {
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
				client.clientRun(5001);
				boolean isConnected = true;
				// create private key.pem
				String moSub1PublicFileName = "mo_sub1_public_"+sub1CertCount+".pem";
				sUtils.generateEcKeyPair(moSub1PrivateFileName, moSub1PublicFileName);
				// create mo_subCA1_csr
				String csrFileName = "mo_subCA1_csr.pem";
				sUtils.generateCsr(moSub1PrivateFileName, moSub1PublicFileName, moSubCa1Dn, csrFileName);
				// send csr to RootCA
				String moSub1CertName = "mo_subCA1_cert_"+sub1CertCount+".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, moSub1CertName);
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
							myCertList.add(new CertData(moSub1CertName,moSub1PrivateFileName, moSub1PublicFileName, rootCertName));
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
