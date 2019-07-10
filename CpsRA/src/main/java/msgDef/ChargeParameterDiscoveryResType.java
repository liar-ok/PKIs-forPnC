//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ChargeParameterDiscoveryResType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ChargeParameterDiscoveryResType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{urn:iso:15118:2:2013:MsgDataTypes}responseCodeType"/>
 *         &lt;element name="EVSEProcessing" type="{urn:iso:15118:2:2013:MsgDataTypes}EVSEProcessingType"/>
 *         &lt;element ref="{urn:iso:15118:2:2013:MsgDataTypes}SASchedules" minOccurs="0"/>
 *         &lt;element ref="{urn:iso:15118:2:2013:MsgDataTypes}EVSEChargeParameter"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeParameterDiscoveryResType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "responseCode",
    "evseProcessing",
    "saSchedules",
    "evseChargeParameter"
})
public class ChargeParameterDiscoveryResType
    extends BodyBaseType
{

    @XmlElement(name = "ResponseCode", required = true)
    @XmlSchemaType(name = "string")
    protected ResponseCodeType responseCode;
    @XmlElement(name = "EVSEProcessing", required = true)
    @XmlSchemaType(name = "string")
    protected EVSEProcessingType evseProcessing;
    @XmlElementRef(name = "SASchedules", namespace = "urn:iso:15118:2:2013:MsgDataTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends SASchedulesType> saSchedules;
    @XmlElementRef(name = "EVSEChargeParameter", namespace = "urn:iso:15118:2:2013:MsgDataTypes", type = JAXBElement.class)
    protected JAXBElement<? extends EVSEChargeParameterType> evseChargeParameter;

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
     * evseProcessing �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EVSEProcessingType }
     *     
     */
    public EVSEProcessingType getEVSEProcessing() {
        return evseProcessing;
    }

    /**
     * evseProcessing �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EVSEProcessingType }
     *     
     */
    public void setEVSEProcessing(EVSEProcessingType value) {
        this.evseProcessing = value;
    }

    /**
     * saSchedules �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SAScheduleListType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SASchedulesType }{@code >}
     *     
     */
    public JAXBElement<? extends SASchedulesType> getSASchedules() {
        return saSchedules;
    }

    /**
     * saSchedules �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SAScheduleListType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SASchedulesType }{@code >}
     *     
     */
    public void setSASchedules(JAXBElement<? extends SASchedulesType> value) {
        this.saSchedules = value;
    }

    /**
     * evseChargeParameter �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EVSEChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ACEVSEChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DCEVSEChargeParameterType }{@code >}
     *     
     */
    public JAXBElement<? extends EVSEChargeParameterType> getEVSEChargeParameter() {
        return evseChargeParameter;
    }

    /**
     * evseChargeParameter �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EVSEChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ACEVSEChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DCEVSEChargeParameterType }{@code >}
     *     
     */
    public void setEVSEChargeParameter(JAXBElement<? extends EVSEChargeParameterType> value) {
        this.evseChargeParameter = value;
    }

}
