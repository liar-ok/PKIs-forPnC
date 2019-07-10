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
 * <p>DC_EVSEChargeParameterType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="DC_EVSEChargeParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVSEChargeParameterType">
 *       &lt;sequence>
 *         &lt;element name="DC_EVSEStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVSEStatusType"/>
 *         &lt;element name="EVSEMaximumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMaximumPowerLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMaximumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMinimumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMinimumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSECurrentRegulationTolerance" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVSEPeakCurrentRipple" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEEnergyToBeDelivered" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DC_EVSEChargeParameterType", propOrder = {
    "dcevseStatus",
    "evseMaximumCurrentLimit",
    "evseMaximumPowerLimit",
    "evseMaximumVoltageLimit",
    "evseMinimumCurrentLimit",
    "evseMinimumVoltageLimit",
    "evseCurrentRegulationTolerance",
    "evsePeakCurrentRipple",
    "evseEnergyToBeDelivered"
})
public class DCEVSEChargeParameterType
    extends EVSEChargeParameterType
{

    @XmlElement(name = "DC_EVSEStatus", required = true)
    protected DCEVSEStatusType dcevseStatus;
    @XmlElement(name = "EVSEMaximumCurrentLimit", required = true)
    protected PhysicalValueType evseMaximumCurrentLimit;
    @XmlElement(name = "EVSEMaximumPowerLimit", required = true)
    protected PhysicalValueType evseMaximumPowerLimit;
    @XmlElement(name = "EVSEMaximumVoltageLimit", required = true)
    protected PhysicalValueType evseMaximumVoltageLimit;
    @XmlElement(name = "EVSEMinimumCurrentLimit", required = true)
    protected PhysicalValueType evseMinimumCurrentLimit;
    @XmlElement(name = "EVSEMinimumVoltageLimit", required = true)
    protected PhysicalValueType evseMinimumVoltageLimit;
    @XmlElement(name = "EVSECurrentRegulationTolerance")
    protected PhysicalValueType evseCurrentRegulationTolerance;
    @XmlElement(name = "EVSEPeakCurrentRipple", required = true)
    protected PhysicalValueType evsePeakCurrentRipple;
    @XmlElement(name = "EVSEEnergyToBeDelivered")
    protected PhysicalValueType evseEnergyToBeDelivered;

    /**
     * dcevseStatus �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link DCEVSEStatusType }
     *     
     */
    public DCEVSEStatusType getDCEVSEStatus() {
        return dcevseStatus;
    }

    /**
     * dcevseStatus �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link DCEVSEStatusType }
     *     
     */
    public void setDCEVSEStatus(DCEVSEStatusType value) {
        this.dcevseStatus = value;
    }

    /**
     * evseMaximumCurrentLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumCurrentLimit() {
        return evseMaximumCurrentLimit;
    }

    /**
     * evseMaximumCurrentLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumCurrentLimit(PhysicalValueType value) {
        this.evseMaximumCurrentLimit = value;
    }

    /**
     * evseMaximumPowerLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumPowerLimit() {
        return evseMaximumPowerLimit;
    }

    /**
     * evseMaximumPowerLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumPowerLimit(PhysicalValueType value) {
        this.evseMaximumPowerLimit = value;
    }

    /**
     * evseMaximumVoltageLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumVoltageLimit() {
        return evseMaximumVoltageLimit;
    }

    /**
     * evseMaximumVoltageLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumVoltageLimit(PhysicalValueType value) {
        this.evseMaximumVoltageLimit = value;
    }

    /**
     * evseMinimumCurrentLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMinimumCurrentLimit() {
        return evseMinimumCurrentLimit;
    }

    /**
     * evseMinimumCurrentLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMinimumCurrentLimit(PhysicalValueType value) {
        this.evseMinimumCurrentLimit = value;
    }

    /**
     * evseMinimumVoltageLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMinimumVoltageLimit() {
        return evseMinimumVoltageLimit;
    }

    /**
     * evseMinimumVoltageLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMinimumVoltageLimit(PhysicalValueType value) {
        this.evseMinimumVoltageLimit = value;
    }

    /**
     * evseCurrentRegulationTolerance �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSECurrentRegulationTolerance() {
        return evseCurrentRegulationTolerance;
    }

    /**
     * evseCurrentRegulationTolerance �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSECurrentRegulationTolerance(PhysicalValueType value) {
        this.evseCurrentRegulationTolerance = value;
    }

    /**
     * evsePeakCurrentRipple �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEPeakCurrentRipple() {
        return evsePeakCurrentRipple;
    }

    /**
     * evsePeakCurrentRipple �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEPeakCurrentRipple(PhysicalValueType value) {
        this.evsePeakCurrentRipple = value;
    }

    /**
     * evseEnergyToBeDelivered �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEEnergyToBeDelivered() {
        return evseEnergyToBeDelivered;
    }

    /**
     * evseEnergyToBeDelivered �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEEnergyToBeDelivered(PhysicalValueType value) {
        this.evseEnergyToBeDelivered = value;
    }

}
