//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CertificateUpdateResType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="CertificateUpdateResType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{urn:iso:15118:2:2013:MsgDataTypes}responseCodeType"/>
 *         &lt;element name="SAProvisioningCertificateChain" type="{urn:iso:15118:2:2013:MsgDataTypes}CertificateChainType"/>
 *         &lt;element name="ContractSignatureCertChain" type="{urn:iso:15118:2:2013:MsgDataTypes}CertificateChainType"/>
 *         &lt;element name="ContractSignatureEncryptedPrivateKey" type="{urn:iso:15118:2:2013:MsgDataTypes}ContractSignatureEncryptedPrivateKeyType"/>
 *         &lt;element name="DHpublickey" type="{urn:iso:15118:2:2013:MsgDataTypes}DiffieHellmanPublickeyType"/>
 *         &lt;element name="eMAID" type="{urn:iso:15118:2:2013:MsgDataTypes}EMAIDType"/>
 *         &lt;element name="RetryCounter" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateUpdateResType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "responseCode",
    "saProvisioningCertificateChain",
    "contractSignatureCertChain",
    "contractSignatureEncryptedPrivateKey",
    "dHpublickey",
    "emaid",
    "retryCounter"
})
public class CertificateUpdateResType
    extends BodyBaseType
{

    @XmlElement(name = "ResponseCode", required = true)
    @XmlSchemaType(name = "string")
    protected ResponseCodeType responseCode;
    @XmlElement(name = "SAProvisioningCertificateChain", required = true)
    protected CertificateChainType saProvisioningCertificateChain;
    @XmlElement(name = "ContractSignatureCertChain", required = true)
    protected CertificateChainType contractSignatureCertChain;
    @XmlElement(name = "ContractSignatureEncryptedPrivateKey", required = true)
    protected ContractSignatureEncryptedPrivateKeyType contractSignatureEncryptedPrivateKey;
    @XmlElement(name = "DHpublickey", required = true)
    protected DiffieHellmanPublickeyType dHpublickey;
    @XmlElement(name = "eMAID", required = true)
    protected EMAIDType emaid;
    @XmlElement(name = "RetryCounter")
    protected Short retryCounter;

    /**
     * responseCode �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCodeType }
     *     
     */
    public ResponseCodeType getResponseCode() {
        return responseCode;
    }

    /**
     * responseCode �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCodeType }
     *     
     */
    public void setResponseCode(ResponseCodeType value) {
        this.responseCode = value;
    }

    /**
     * saProvisioningCertificateChain �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link CertificateChainType }
     *     
     */
    public CertificateChainType getSAProvisioningCertificateChain() {
        return saProvisioningCertificateChain;
    }

    /**
     * saProvisioningCertificateChain �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateChainType }
     *     
     */
    public void setSAProvisioningCertificateChain(CertificateChainType value) {
        this.saProvisioningCertificateChain = value;
    }

    /**
     * contractSignatureCertChain �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link CertificateChainType }
     *     
     */
    public CertificateChainType getContractSignatureCertChain() {
        return contractSignatureCertChain;
    }

    /**
     * contractSignatureCertChain �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateChainType }
     *     
     */
    public void setContractSignatureCertChain(CertificateChainType value) {
        this.contractSignatureCertChain = value;
    }

    /**
     * contractSignatureEncryptedPrivateKey �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ContractSignatureEncryptedPrivateKeyType }
     *     
     */
    public ContractSignatureEncryptedPrivateKeyType getContractSignatureEncryptedPrivateKey() {
        return contractSignatureEncryptedPrivateKey;
    }

    /**
     * contractSignatureEncryptedPrivateKey �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractSignatureEncryptedPrivateKeyType }
     *     
     */
    public void setContractSignatureEncryptedPrivateKey(ContractSignatureEncryptedPrivateKeyType value) {
        this.contractSignatureEncryptedPrivateKey = value;
    }

    /**
     * dHpublickey �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link DiffieHellmanPublickeyType }
     *     
     */
    public DiffieHellmanPublickeyType getDHpublickey() {
        return dHpublickey;
    }

    /**
     * dHpublickey �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link DiffieHellmanPublickeyType }
     *     
     */
    public void setDHpublickey(DiffieHellmanPublickeyType value) {
        this.dHpublickey = value;
    }

    /**
     * emaid �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EMAIDType }
     *     
     */
    public EMAIDType getEMAID() {
        return emaid;
    }

    /**
     * emaid �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EMAIDType }
     *     
     */
    public void setEMAID(EMAIDType value) {
        this.emaid = value;
    }

    /**
     * retryCounter �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getRetryCounter() {
        return retryCounter;
    }

    /**
     * retryCounter �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRetryCounter(Short value) {
        this.retryCounter = value;
    }

}
