package moRA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();

		int mainFlag = 1;
		int contractCertCount = 0;
		String rootCertName = null;
		String oemRootCertName = null;
		String pcid = "MJUC5OKXL3K6VC537";
		List<ContractCertData> contractCertList = new ArrayList<>();
		List<ProvCertData> provCertList = new ArrayList<ProvCertData>();

		while (mainFlag == 1) {
			System.out.println("MO RA=====================");
			System.out.println(
					"1. request to get MO, OEM Root Certificate\n2. request OEM Provisioning Certificate to OEM\n3. request contract certificate\n4. send ContractData to CPS\n5. send ContractData to CPS-2");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(5001);
				boolean isConnected = true;
				// request to get mo Root certificate
				byte[] sendData = sUtils.makeReqToGetMORootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to MOrootCA");
				while (isConnected) {
					
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
				
				// request to get oem Root Certificate
				client.clientRun(2001);
				isConnected = true;
				// request to get oem Root certificate
				sendData = sUtils.makeReqToGetOEMRootCertMsg();
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
							oemRootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with oem root CA");
						}
					}
				}
			}else if(inputValue == 2) {
				//3. request OEM Provisioning Certificate to OEM
				//connect with OEMRA
				client.clientRun(2004);
				boolean isConnected = true;
				//request oem prov cert with pcid
				//assume that MO RA already knows the PCID
				
				byte[] sendData = sUtils.makeReqToGetOEMProvCertMsg(pcid);
				client.sendPacket(sendData);
				System.out.println("send request to OEM RA");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : oem prov CertName, saveCertList(1) : subCA2CertName,
							// saveCertList(2) : subCA1CertName
							provCertList.add(new ProvCertData(pcid, saveCertList.get(0),
									saveCertList.get(1), saveCertList.get(2), oemRootCertName));
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with oem RA");
						}
					}
				}
			}else if (inputValue == 3) {
				client.clientRun(5003);
				boolean isConnected = true;
				// create private key.pem
				String moContractPrivateFileName = "mo_contract_private" + contractCertCount + ".pem";
				String moContractPublicFileName = "mo_contract_public_" + contractCertCount + ".pem";
				sUtils.generateEcKeyPair(moContractPrivateFileName, moContractPublicFileName);
				// create mo_contract_csr
				String csrFileName = "mo_contract_csr.pem";
				String eMAID = sUtils.generateEmaid();
				String moContractDn = "C=KR, O=MJU, OU=HMCL, CN=" + eMAID + ", DC=V2G";
				sUtils.generateCsr(moContractPrivateFileName, moContractPublicFileName, moContractDn, csrFileName);
				// send csr to subCA2
				String moContractCertName = "mo_contract_cert_" + contractCertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, moContractCertName);
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
							contractCertList.add(new ContractCertData(eMAID, moContractCertName, moContractPrivateFileName, moContractPublicFileName,
									saveCertList.get(1), saveCertList.get(2), rootCertName,pcid));
							contractCertCount++;
							System.out.println("save cert in pem file");
							System.out.println("eMAID is : " + eMAID);
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with Sub CA2");
						}
					}
				}				
			} else if (inputValue == 4) {
				// connect with cps RA
				client.clientRun(51003);
				boolean isConnected = true;
				ContractCertData certData =contractCertList.get(0);
				String contractCertPrivateKeyFileName = certData.getPrivateFileName();
				// generate DH key pair
				String dhPublicKeyFileName = "DH_public.pem";
				String dhPrivateKeyFileName = "DH_private.pem";
				sUtils.generateEcKeyPair(dhPrivateKeyFileName, dhPublicKeyFileName);
				String oemProvCertFileName = provCertList.get(0).getCertName();
				// generate session key from ECDHE(with OEM PublicKey, DH privateKey,
				// OEMProvCert.privateKey) and encrypt contractCert'sprivateKey
				byte[] encryptedContractCertPrivateKey = sUtils.encryptContractCertPrivateKey(
						oemProvCertFileName,
						dhPrivateKeyFileName, contractCertPrivateKeyFileName);
				System.out.println("ready to send it");
				// send ContractData to cps RA
				byte[] sendData = sUtils.makeContractDataMsg(certData, dhPublicKeyFileName, encryptedContractCertPrivateKey, pcid);
				client.sendPacket(sendData);
				System.out.println("send contract data to CPS RA");
				while(isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with CPS RA");
						}else if(type.equals("SuccessToGetContractData")) {
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
							System.out.println("req to finish connection");
						}
					}
				
				}
			}else if(inputValue == 5) {
				//connect with cps-2 RA
				client.clientRun(21004);
				boolean isConnected = true;
				ContractCertData certData =contractCertList.get(0);
				String contractCertPrivateKeyFileName = certData.getPrivateFileName();
				// generate DH key pair
				String dhPublicKeyFileName = "DH_public.pem";
				String dhPrivateKeyFileName = "DH_private.pem";
				sUtils.generateEcKeyPair(dhPrivateKeyFileName, dhPublicKeyFileName);
				String oemProvCertFileName = provCertList.get(0).getCertName();
				// generate session key from ECDHE(with OEM PublicKey, DH privateKey,
				// OEMProvCert.privateKey) and encrypt contractCert'sprivateKey
				byte[] encryptedContractCertPrivateKey = sUtils.encryptContractCertPrivateKey(
						oemProvCertFileName,
						dhPrivateKeyFileName, contractCertPrivateKeyFileName);
				System.out.println("ready to send it");
				// send ContractData to cps-2 RA
				byte[] sendData = sUtils.makeContractDataMsg(certData, dhPublicKeyFileName, encryptedContractCertPrivateKey, pcid);
				client.sendPacket(sendData);
				System.out.println("send contract data to CPS-2 RA");
				while(isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with CPS-2 RA");
						}else if(type.equals("SuccessToGetContractData")) {
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
							System.out.println("req to finish connection");
						}
					}
				
				}
			}else {
				
			}
		}
	}
}
