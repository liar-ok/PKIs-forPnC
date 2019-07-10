//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CertificateUpdateResType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * responseCode 속성의 값을 가져옵니다.
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
     * responseCode 속성의 값을 설정합니다.
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
     * saProvisioningCertificateChain 속성의 값을 가져옵니다.
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
     * saProvisioningCertificateChain 속성의 값을 설정합니다.
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
     * contractSignatureCertChain 속성의 값을 가져옵니다.
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
     * contractSignatureCertChain 속성의 값을 설정합니다.
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
     * contractSignatureEncryptedPrivateKey 속성의 값을 가져옵니다.
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
     * contractSignatureEncryptedPrivateKey 속성의 값을 설정합니다.
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
     * dHpublickey 속성의 값을 가져옵니다.
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
     * dHpublickey 속성의 값을 설정합니다.
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
     * emaid 속성의 값을 가져옵니다.
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
     * emaid 속성의 값을 설정합니다.
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
     * retryCounter 속성의 값을 가져옵니다.
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
     * retryCounter 속성의 값을 설정합니다.
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
