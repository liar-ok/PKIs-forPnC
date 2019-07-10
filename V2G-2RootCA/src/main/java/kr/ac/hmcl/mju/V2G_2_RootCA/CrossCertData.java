package kr.ac.hmcl.mju.V2G_2_RootCA;

public class CrossCertData {

	private String certName;
	private String privateFileName;
	private String publicFileName;
	private String sameKeyCertName;
	
	public CrossCertData(String certName, String privateFileName, String publicFileName, String sameKeyCertName) {
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.publicFileName = publicFileName;
		this.sameKeyCertName = sameKeyCertName;
	}
	
	public CrossCertData(CrossCertData crossCertData) {
		this.certName = crossCertData.getCertName();
		this.privateFileName = crossCertData.getPrivateFileName();
		this.publicFileName = crossCertData.getPublicFileName();
		this.sameKeyCertName = crossCertData.getSameKeyCertName();
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getPrivateFileName() {
		return privateFileName;
	}

	public void setPrivateFileName(String privateFileName) {
		this.privateFileName = privateFileName;
	}

	public String getPublicFileName() {
		return publicFileName;
	}

	public void setPublicFileName(String publicFileName) {
		this.publicFileName = publicFileName;
	}

	public String getSameKeyCertName() {
		return sameKeyCertName;
	}

	public void setSameKeyCertName(String sameKeyCertName) {
		this.sameKeyCertName = sameKeyCertName;
	}

}
