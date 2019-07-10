//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ProfileEntryType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ProfileEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChargingProfileEntryStart" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChargingProfileEntryMaxPower" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="ChargingProfileEntryMaxNumberOfPhasesInUse" type="{urn:iso:15118:2:2013:MsgDataTypes}maxNumPhasesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileEntryType", propOrder = {
    "chargingProfileEntryStart",
    "chargingProfileEntryMaxPower",
    "chargingProfileEntryMaxNumberOfPhasesInUse"
})
public class ProfileEntryType {

    @XmlElement(name = "ChargingProfileEntryStart")
    @XmlSchemaType(name = "unsignedInt")
    protected long chargingProfileEntryStart;
    @XmlElement(name = "ChargingProfileEntryMaxPower", required = true)
    protected PhysicalValueType chargingProfileEntryMaxPower;
    @XmlElement(name = "ChargingProfileEntryMaxNumberOfPhasesInUse")
    protected Byte chargingProfileEntryMaxNumberOfPhasesInUse;

    /**
     * chargingProfileEntryStart �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public long getChargingProfileEntryStart() {
        return chargingProfileEntryStart;
    }

    /**
     * chargingProfileEntryStart �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setChargingProfileEntryStart(long value) {
        this.chargingProfileEntryStart = value;
    }

    /**
     * chargingProfileEntryMaxPower �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getChargingProfileEntryMaxPower() {
        return chargingProfileEntryMaxPower;
    }

    /**
     * chargingProfileEntryMaxPower �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setChargingProfileEntryMaxPower(PhysicalValueType value) {
        this.chargingProfileEntryMaxPower = value;
    }

    /**
     * chargingProfileEntryMaxNumberOfPhasesInUse �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getChargingProfileEntryMaxNumberOfPhasesInUse() {
        return chargingProfileEntryMaxNumberOfPhasesInUse;
    }

    /**
     * chargingProfileEntryMaxNumberOfPhasesInUse �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setChargingProfileEntryMaxNumberOfPhasesInUse(Byte value) {
        this.chargingProfileEntryMaxNumberOfPhasesInUse = value;
    }

}
