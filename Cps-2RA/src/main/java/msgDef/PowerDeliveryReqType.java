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
 * <p>PowerDeliveryReqType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="PowerDeliveryReqType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ChargeProgress" type="{urn:iso:15118:2:2013:MsgDataTypes}chargeProgressType"/>
 *         &lt;element name="SAScheduleTupleID" type="{urn:iso:15118:2:2013:MsgDataTypes}SAIDType"/>
 *         &lt;element name="ChargingProfile" type="{urn:iso:15118:2:2013:MsgDataTypes}ChargingProfileType" minOccurs="0"/>
 *         &lt;element ref="{urn:iso:15118:2:2013:MsgDataTypes}EVPowerDeliveryParameter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerDeliveryReqType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "chargeProgress",
    "saScheduleTupleID",
    "chargingProfile",
    "evPowerDeliveryParameter"
})
public class PowerDeliveryReqType
    extends BodyBaseType
{

    @XmlElement(name = "ChargeProgress", required = true)
    @XmlSchemaType(name = "string")
    protected ChargeProgressType chargeProgress;
    @XmlElement(name = "SAScheduleTupleID")
    @XmlSchemaType(name = "unsignedByte")
    protected short saScheduleTupleID;
    @XmlElement(name = "ChargingProfile")
    protected ChargingProfileType chargingProfile;
    @XmlElementRef(name = "EVPowerDeliveryParameter", namespace = "urn:iso:15118:2:2013:MsgDataTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends EVPowerDeliveryParameterType> evPowerDeliveryParameter;

    /**
     * chargeProgress 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ChargeProgressType }
     *     
     */
    public ChargeProgressType getChargeProgress() {
        return chargeProgress;
    }

    /**
     * chargeProgress 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeProgressType }
     *     
     */
    public void setChargeProgress(ChargeProgressType value) {
        this.chargeProgress = value;
    }

    /**
     * saScheduleTupleID 속성의 값을 가져옵니다.
     * 
     */
    public short getSAScheduleTupleID() {
        return saScheduleTupleID;
    }

    /**
     * saScheduleTupleID 속성의 값을 설정합니다.
     * 
     */
    public void setSAScheduleTupleID(short value) {
        this.saScheduleTupleID = value;
    }

    /**
     * chargingProfile 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ChargingProfileType }
     *     
     */
    public ChargingProfileType getChargingProfile() {
        return chargingProfile;
    }

    /**
     * chargingProfile 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingProfileType }
     *     
     */
    public void setChargingProfile(ChargingProfileType value) {
        this.chargingProfile = value;
    }

    /**
     * evPowerDeliveryParameter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DCEVPowerDeliveryParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EVPowerDeliveryParameterType }{@code >}
     *     
     */
    public JAXBElement<? extends EVPowerDeliveryParameterType> getEVPowerDeliveryParameter() {
        return evPowerDeliveryParameter;
    }

    /**
     * evPowerDeliveryParameter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DCEVPowerDeliveryParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EVPowerDeliveryParameterType }{@code >}
     *     
     */
    public void setEVPowerDeliveryParameter(JAXBElement<? extends EVPowerDeliveryParameterType> value) {
        this.evPowerDeliveryParameter = value;
    }

}
