package CPORA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();

		int mainFlag = 1;
		int leafCertCount = 0;
		String rootCertName = null;
		//List<ContractCertData> contractCertList = new ArrayList<>();
		List<CertData> leafCertList = new ArrayList<>();

		while (mainFlag == 1) {
			System.out.println("CPO RA");
			System.out.println(
					"1. request to get V2G Root certificate\n2. request EVSE Leaf certificate");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(1001);
				boolean isConnected = true;
				// request to get v2g Root certificate
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
							// saveCertList(0) : V2G Root Cert Name
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
				client.clientRun(1013);
				boolean isConnected = true;
				// create private key.pem
				String cpoLeafPrivateFileName = "cpo_leaf_private" + leafCertCount + ".pem";
				String cpoLeafPublicFileName = "cpo_leaf_public_" + leafCertCount + ".pem";
				sUtils.generateEcKeyPair(cpoLeafPrivateFileName, cpoLeafPublicFileName);
				// create cpo_leaf_csr
				String csrFileName = "cpo_leaf_csr.pem";
				String cpoLeafDn = "C=KR, O=MJU, OU=HMCL, CN= MJU_CPO_LEAF, DC=CPO";
				sUtils.generateCsr(cpoLeafPrivateFileName, cpoLeafPublicFileName, cpoLeafDn, csrFileName);
				// send csr to subCA2
				String cpoLeafCertName = "cpo_leaf_cert_" + leafCertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, cpoLeafCertName);
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
							leafCertList.add(new CertData(cpoLeafCertName, cpoLeafPrivateFileName, cpoLeafPublicFileName, saveCertList.get(1), saveCertList.get(2), rootCertName));
							leafCertCount++;
							System.out.println("save cert in pem file");
							//finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						}else if(type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					} else {
						System.out.println("receive NULL data");
					}
				}				
			} 
		}

}}
