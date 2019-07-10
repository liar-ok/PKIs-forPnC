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
 * <p>ServiceDiscoveryResType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ServiceDiscoveryResType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{urn:iso:15118:2:2013:MsgDataTypes}responseCodeType"/>
 *         &lt;element name="PaymentOptionList" type="{urn:iso:15118:2:2013:MsgDataTypes}PaymentOptionListType"/>
 *         &lt;element name="ChargeService" type="{urn:iso:15118:2:2013:MsgDataTypes}ChargeServiceType"/>
 *         &lt;element name="ServiceList" type="{urn:iso:15118:2:2013:MsgDataTypes}ServiceListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDiscoveryResType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "responseCode",
    "paymentOptionList",
    "chargeService",
    "serviceList"
})
public class ServiceDiscoveryResType
    extends BodyBaseType
{

    @XmlElement(name = "ResponseCode", required = true)
    @XmlSchemaType(name = "string")
    protected ResponseCodeType responseCode;
    @XmlElement(name = "PaymentOptionList", required = true)
    protected PaymentOptionListType paymentOptionList;
    @XmlElement(name = "ChargeService", required = true)
    protected ChargeServiceType chargeService;
    @XmlElement(name = "ServiceList")
    protected ServiceListType serviceList;

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
     * paymentOptionList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PaymentOptionListType }
     *     
     */
    public PaymentOptionListType getPaymentOptionList() {
        return paymentOptionList;
    }

    /**
     * paymentOptionList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentOptionListType }
     *     
     */
    public void setPaymentOptionList(PaymentOptionListType value) {
        this.paymentOptionList = value;
    }

    /**
     * chargeService �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ChargeServiceType }
     *     
     */
    public ChargeServiceType getChargeService() {
        return chargeService;
    }

    /**
     * chargeService �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeServiceType }
     *     
     */
    public void setChargeService(ChargeServiceType value) {
        this.chargeService = value;
    }

    /**
     * serviceList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ServiceListType }
     *     
     */
    public ServiceListType getServiceList() {
        return serviceList;
    }

    /**
     * serviceList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceListType }
     *     
     */
    public void setServiceList(ServiceListType value) {
        this.serviceList = value;
    }

}
