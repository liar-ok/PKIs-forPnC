package kr.ac.hmcl.mju.Cps_2_RA;

public class CertData {

	private String certName;
	private String privateFileName;
	private String publicFileName;
	private String subCa1CertName;
	private String subCa2CertName;
	private String rootCertName;
	public CertData(String certName, String privateFileName, String publicFileName) {
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.publicFileName = publicFileName;
		
		//when save data of root CA cert
	}
	
	public CertData(String certName, String privateFileName, String publicFileName, String rootCertName) {
		super();
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.publicFileName = publicFileName;
		this.rootCertName = rootCertName;
		
		//when save data of subCA1 cert
	}

	public CertData(String certName, String privateFileName, String publicFileName, String subCa1CertName, String rootCertName) {
		super();
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.publicFileName = publicFileName;
		this.subCa1CertName = subCa1CertName;
		this.rootCertName = rootCertName;
		
		//when save data of subCA2 Cert
	}
	
	public CertData(String certName, String privateFileName, String publicFileName, String subCa1CertName, String subCa2CertName, String rootCertName) {
		super();
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.publicFileName = publicFileName;
		this.subCa1CertName = subCa1CertName;
		this.subCa2CertName = subCa2CertName;
		this.rootCertName = rootCertName;
	}

	public CertData(CertData certData) {
		this.certName = certData.getCertName();
		this.privateFileName = certData.getPrivateFileName();
		this.publicFileName = certData.getPublicFileName();
		this.subCa2CertName = certData.getSubCa2CertName();
		this.subCa1CertName = certData.getSubCa1CertName();
		this.rootCertName = certData.getRootCertName();
	}
	public String getPublicFileName() {
		return publicFileName;
	}

	public void setPublicFileName(String publicFileName) {
		this.publicFileName = publicFileName;
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

	public String getSubCa1CertName() {
		return subCa1CertName;
	}

	public void setSubCa1CertName(String subCa1CertName) {
		this.subCa1CertName = subCa1CertName;
	}

	public String getRootCertName() {
		return rootCertName;
	}

	public void setRootCertName(String rootCertName) {
		this.rootCertName = rootCertName;
	}

	public String getSubCa2CertName() {
		return subCa2CertName;
	}

	public void setSubCa2CertName(String subCa2CertName) {
		this.subCa2CertName = subCa2CertName;
	}
	
}
