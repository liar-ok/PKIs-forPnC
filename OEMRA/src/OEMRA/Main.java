package OEMRA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;
	
	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(2004);
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer(); 
						server.serverRun(2004);
						System.out.println("finish the connection");
						System.out.println("OEM RA=================================================");
						System.out.println(
								"1. request to get OEM Root certificate\n2. request OEM Leaf certificate");
					}else if(type.equals("ReqToGetOEMProvCert")) {
						//get pcid from msg
						String pcid = sUtils.readReqToGetOEMProvCertMsg(getData);
						System.out.println("requested PCID is : " + pcid);
						//find certificate with pcid
						int size = Main.leafCertList.size();
						int target = 0;
						for(int i = 0; i < size; i++) {
							if(Main.leafCertList.get(i).getPcid().equals(pcid)) {
								target = i;
								i = size;
							}
						}
						//send oemProvCert
						ProvCertData provCertData = Main.leafCertList.get(target);
						List<String> certList = new ArrayList();
						certList.add(provCertData.getCertName()); //prov cert name
						certList.add(provCertData.getSubCa2CertName()); //subca2 cert name
						certList.add(provCertData.getSubCa1CertName()); // subca1 cert name
						byte[] sendData = sUtils.makeResWithCertMsg(certList);
						server.sendPacket(sendData);
					}
				}
			}
		} catch (Exception e) {
		}

	}
}


public class Main {
	public static List<ProvCertData> leafCertList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();
		ServerThread st = new ServerThread();
		st.start();

		int mainFlag = 1;
		int leafCertCount = 0;
		String rootCertName = null;


		while (mainFlag == 1) {
			System.out.println("OEM RA=================================================");
			System.out.println(
					"1. request to get OEM Root certificate\n2. request OEM Leaf certificate");
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
				client.clientRun(2003);
				boolean isConnected = true;
				// create private key.pem
				String oemLeafPrivateFileName = "oem_leaf_private" + leafCertCount + ".pem";
				String oemLeafPublicFileName = "oem_leaf_public_" + leafCertCount + ".pem";
				sUtils.generateEcKeyPair(oemLeafPrivateFileName, oemLeafPublicFileName);
				// create oem_leaf_csr
				String csrFileName = "oem_leaf_csr.pem";
				String pcid = sUtils.generatePCID();
				String oemLeafDn = "C=KR, O=MJU, OU=HMCL, CN=" + pcid + ", DC=OEM";
				sUtils.generateCsr(oemLeafPrivateFileName, oemLeafPublicFileName, oemLeafDn, csrFileName);
				// send csr to subCA2
				String oemLeafCertName = "oem_leaf_cert_" + leafCertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, oemLeafCertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to subCA2");
				while(isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : contractCertName, saveCertList(1) : subCA2CertName,
							// saveCertList(2) : subCA1CertName
							leafCertList.add(new ProvCertData(pcid, oemLeafCertName, oemLeafPrivateFileName, saveCertList.get(1), saveCertList.get(2), rootCertName));
							leafCertCount++;
							System.out.println("save cert in pem file");
							System.out.println("Sucess to issue OEM Provisioning Certificate: "+ leafCertList.get(leafCertList.size()-1).getPcid());
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with sub CA2");
						}
					} else {
						System.out.println("receive NULL data");
					}
				}				
			}
		}

}}
