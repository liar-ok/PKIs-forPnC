//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>CertificateInstallationReqType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="CertificateInstallationReqType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="OEMProvisioningCert" type="{urn:iso:15118:2:2013:MsgDataTypes}certificateType"/>
 *         &lt;element name="ListOfRootCertificateIDs" type="{urn:iso:15118:2:2013:MsgDataTypes}ListOfRootCertificateIDsType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateInstallationReqType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "oemProvisioningCert",
    "listOfRootCertificateIDs"
})
public class CertificateInstallationReqType
    extends BodyBaseType
{

    @XmlElement(name = "OEMProvisioningCert", required = true)
    protected byte[] oemProvisioningCert;
    @XmlElement(name = "ListOfRootCertificateIDs", required = true)
    protected ListOfRootCertificateIDsType listOfRootCertificateIDs;
    @XmlAttribute(name = "Id", namespace = "urn:iso:15118:2:2013:MsgBody", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * oemProvisioningCert �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOEMProvisioningCert() {
        return oemProvisioningCert;
    }

    /**
     * oemProvisioningCert �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOEMProvisioningCert(byte[] value) {
        this.oemProvisioningCert = value;
    }

    /**
     * listOfRootCertificateIDs �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ListOfRootCertificateIDsType }
     *     
     */
    public ListOfRootCertificateIDsType getListOfRootCertificateIDs() {
        return listOfRootCertificateIDs;
    }

    /**
     * listOfRootCertificateIDs �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfRootCertificateIDsType }
     *     
     */
    public void setListOfRootCertificateIDs(ListOfRootCertificateIDsType value) {
        this.listOfRootCertificateIDs = value;
    }

    /**
     * id �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
