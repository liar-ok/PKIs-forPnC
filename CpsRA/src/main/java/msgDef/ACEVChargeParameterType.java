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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AC_EVChargeParameterType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="AC_EVChargeParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVChargeParameterType">
 *       &lt;sequence>
 *         &lt;element name="EAmount" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVMaxVoltage" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVMaxCurrent" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVMinCurrent" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AC_EVChargeParameterType", propOrder = {
    "eAmount",
    "evMaxVoltage",
    "evMaxCurrent",
    "evMinCurrent"
})
public class ACEVChargeParameterType
    extends EVChargeParameterType
{

    @XmlElement(name = "EAmount", required = true)
    protected PhysicalValueType eAmount;
    @XmlElement(name = "EVMaxVoltage", required = true)
    protected PhysicalValueType evMaxVoltage;
    @XmlElement(name = "EVMaxCurrent", required = true)
    protected PhysicalValueType evMaxCurrent;
    @XmlElement(name = "EVMinCurrent", required = true)
    protected PhysicalValueType evMinCurrent;

    /**
     * eAmount �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEAmount() {
        return eAmount;
    }

    /**
     * eAmount �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEAmount(PhysicalValueType value) {
        this.eAmount = value;
    }

    /**
     * evMaxVoltage �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVMaxVoltage() {
        return evMaxVoltage;
    }

    /**
     * evMaxVoltage �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVMaxVoltage(PhysicalValueType value) {
        this.evMaxVoltage = value;
    }

    /**
     * evMaxCurrent �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVMaxCurrent() {
        return evMaxCurrent;
    }

    /**
     * evMaxCurrent �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVMaxCurrent(PhysicalValueType value) {
        this.evMaxCurrent = value;
    }

    /**
     * evMinCurrent �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVMinCurrent() {
        return evMinCurrent;
    }

    /**
     * evMinCurrent �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVMinCurrent(PhysicalValueType value) {
        this.evMinCurrent = value;
    }

}
