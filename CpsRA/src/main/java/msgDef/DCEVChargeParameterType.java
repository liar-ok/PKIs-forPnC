//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DC_EVChargeParameterType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * dcevStatus 속성의 값을 가져옵니다.
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
     * dcevStatus 속성의 값을 설정합니다.
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
     * evMaximumCurrentLimit 속성의 값을 가져옵니다.
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
     * evMaximumCurrentLimit 속성의 값을 설정합니다.
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
     * evMaximumPowerLimit 속성의 값을 가져옵니다.
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
     * evMaximumPowerLimit 속성의 값을 설정합니다.
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
     * evMaximumVoltageLimit 속성의 값을 가져옵니다.
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
     * evMaximumVoltageLimit 속성의 값을 설정합니다.
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
     * evEnergyCapacity 속성의 값을 가져옵니다.
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
     * evEnergyCapacity 속성의 값을 설정합니다.
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
     * evEnergyRequest 속성의 값을 가져옵니다.
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
     * evEnergyRequest 속성의 값을 설정합니다.
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
     * fullSOC 속성의 값을 가져옵니다.
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
     * fullSOC 속성의 값을 설정합니다.
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
     * bulkSOC 속성의 값을 가져옵니다.
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
     * bulkSOC 속성의 값을 설정합니다.
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
