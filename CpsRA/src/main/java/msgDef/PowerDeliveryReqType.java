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
 * <p>PowerDeliveryReqType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
     * chargeProgress �Ӽ��� ���� �����ɴϴ�.
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
     * chargeProgress �Ӽ��� ���� �����մϴ�.
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
     * saScheduleTupleID �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public short getSAScheduleTupleID() {
        return saScheduleTupleID;
    }

    /**
     * saScheduleTupleID �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setSAScheduleTupleID(short value) {
        this.saScheduleTupleID = value;
    }

    /**
     * chargingProfile �Ӽ��� ���� �����ɴϴ�.
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
     * chargingProfile �Ӽ��� ���� �����մϴ�.
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
     * evPowerDeliveryParameter �Ӽ��� ���� �����ɴϴ�.
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
     * evPowerDeliveryParameter �Ӽ��� ���� �����մϴ�.
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
