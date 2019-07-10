//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:42 AM KST 
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
 * <p>ChargeParameterDiscoveryResType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * evseProcessing 속성의 값을 가져옵니다.
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
     * evseProcessing 속성의 값을 설정합니다.
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
     * saSchedules 속성의 값을 가져옵니다.
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
     * saSchedules 속성의 값을 설정합니다.
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
     * evseChargeParameter 속성의 값을 가져옵니다.
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
     * evseChargeParameter 속성의 값을 설정합니다.
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
