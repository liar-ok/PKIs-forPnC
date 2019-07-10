package OEMRA;

public class ProvCertData {
	String pcid;
	private String certName;
	private String privateFileName;
	private String subCa2CertName;
	private String subCa1CertName;
	private String rootCertName;

	public ProvCertData(String pcid, String certName, String privateFileName,String subCa2CertName, String subCa1CertName, String rootCertName) {
		this.pcid = pcid;
		this.certName = certName;
		this.privateFileName = privateFileName;
		this.subCa2CertName = subCa2CertName;
		this.subCa1CertName = subCa1CertName;
		this.rootCertName = rootCertName;
	}
	public ProvCertData(String pcid, String certName, String subCa2CertName, String subCa1CertName, String rootCertName) {
		this.pcid = pcid;
		this.certName = certName;
		this.subCa2CertName = subCa2CertName;
		this.subCa1CertName = subCa1CertName;
		this.rootCertName = rootCertName;
	}
	public String getPcid() {
		return pcid;
	}
	public void setPcid(String pcid) {
		this.pcid = pcid;
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
	
	

}
