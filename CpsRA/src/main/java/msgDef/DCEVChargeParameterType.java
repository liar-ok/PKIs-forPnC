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
 * <p>DC_EVChargeParameterType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="DC_EVChargeParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVChargeParameterType">
 *       &lt;sequence>
 *         &lt;element name="DC_EVStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVStatusType"/>
 *         &lt;element name="EVMaximumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVMaximumPowerLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVMaximumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVEnergyCapacity" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVEnergyRequest" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="FullSOC" type="{urn:iso:15118:2:2013:MsgDataTypes}percentValueType" minOccurs="0"/>
 *         &lt;element name="BulkSOC" type="{urn:iso:15118:2:2013:MsgDataTypes}percentValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DC_EVChargeParameterType", propOrder = {
    "dcevStatus",
    "evMaximumCurrentLimit",
    "evMaximumPowerLimit",
    "evMaximumVoltageLimit",
    "evEnergyCapacity",
    "evEnergyRequest",
    "fullSOC",
    "bulkSOC"
})
public class DCEVChargeParameterType
    extends EVChargeParameterType
{

    @XmlElement(name = "DC_EVStatus", required = true)
    protected DCEVStatusType dcevStatus;
    @XmlElement(name = "EVMaximumCurrentLimit", required = true)
    protected PhysicalValueType evMaximumCurrentLimit;
    @XmlElement(name = "EVMaximumPowerLimit")
    protected PhysicalValueType evMaximumPowerLimit;
    @XmlElement(name = "EVMaximumVoltageLimit", required = true)
    protected PhysicalValueType evMaximumVoltageLimit;
    @XmlElement(name = "EVEnergyCapacity")
    protected PhysicalValueType evEnergyCapacity;
    @XmlElement(name = "EVEnergyRequest")
    protected PhysicalValueType evEnergyRequest;
    @XmlElement(name = "FullSOC")
    protected Byte fullSOC;
    @XmlElement(name = "BulkSOC")
    protected Byte bulkSOC;

    /**
     * dcevStatus �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link DCEVStatusType }
     *     
     */
    public DCEVStatusType getDCEVStatus() {
        return dcevStatus;
    }

    /**
     * dcevStatus �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link DCEVStatusType }
     *     
     */
    public void setDCEVStatus(DCEVStatusType value) {
        this.dcevStatus = value;
    }

    /**
     * evMaximumCurrentLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVMaximumCurrentLimit() {
        return evMaximumCurrentLimit;
    }

    /**
     * evMaximumCurrentLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVMaximumCurrentLimit(PhysicalValueType value) {
        this.evMaximumCurrentLimit = value;
    }

    /**
     * evMaximumPowerLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVMaximumPowerLimit() {
        return evMaximumPowerLimit;
    }

    /**
     * evMaximumPowerLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVMaximumPowerLimit(PhysicalValueType value) {
        this.evMaximumPowerLimit = value;
    }

    /**
     * evMaximumVoltageLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVMaximumVoltageLimit() {
        return evMaximumVoltageLimit;
    }

    /**
     * evMaximumVoltageLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVMaximumVoltageLimit(PhysicalValueType value) {
        this.evMaximumVoltageLimit = value;
    }

    /**
     * evEnergyCapacity �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVEnergyCapacity() {
        return evEnergyCapacity;
    }

    /**
     * evEnergyCapacity �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVEnergyCapacity(PhysicalValueType value) {
        this.evEnergyCapacity = value;
    }

    /**
     * evEnergyRequest �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVEnergyRequest() {
        return evEnergyRequest;
    }

    /**
     * evEnergyRequest �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVEnergyRequest(PhysicalValueType value) {
        this.evEnergyRequest = value;
    }

    /**
     * fullSOC �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getFullSOC() {
        return fullSOC;
    }

    /**
     * fullSOC �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setFullSOC(Byte value) {
        this.fullSOC = value;
    }

    /**
     * bulkSOC �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getBulkSOC() {
        return bulkSOC;
    }

    /**
     * bulkSOC �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setBulkSOC(Byte value) {
        this.bulkSOC = value;
    }

}
