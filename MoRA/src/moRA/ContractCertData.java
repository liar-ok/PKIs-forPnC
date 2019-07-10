package moRA;

public class ContractCertData {
	private String emaid;
	private String certName;
	private String privateFileName;
	private String publicFileName;
	private String subCa2CertName;
	private String subCa1CertName;
	private String rootCertName;
	private String pcid;

	public ContractCertData(String emaid, String certName, String privateFileName, String publicFileName, String subCa2CertName, String subCa1CertName, String rootCertName, String pcid) {
		this.emaid = emaid;
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.publicFileName = publicFileName;
		this.subCa2CertName = subCa2CertName;
		this.subCa1CertName = subCa1CertName;
		this.rootCertName = rootCertName;
		this.pcid = pcid;
	}
	public String getEmaid() {
		return emaid;
	}
	public void setEmaid(String emaid) {
		this.emaid = emaid;
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
	public String getSubCa2CertName() {
		return subCa2CertName;
	}
	public void setSubCa2CertName(String subCa2CertName) {
		this.subCa2CertName = subCa2CertName;
	}
	public String getSubCa1CertName() {
		return subCa1CertName;
	}
	public void setSubCa1CertName(String subCa1CertNAme) {
		this.subCa1CertName = subCa1CertNAme;
	}
	public String getRootCertName() {
		return rootCertName;
	}
	public void setRootCertName(String rootCertName) {
		this.rootCertName = rootCertName;
	}
	public String getPublicFileName() {
		return publicFileName;
	}
	public void setPublicFileName(String publicFileName) {
		this.publicFileName = publicFileName;
	}
	public String getPcid() {
		return pcid;
	}
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	
	

}
