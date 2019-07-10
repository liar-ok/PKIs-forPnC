//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CurrentDemandReqType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="CurrentDemandReqType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="DC_EVStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVStatusType"/>
 *         &lt;element name="EVTargetCurrent" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVMaximumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVMaximumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVMaximumPowerLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="BulkChargingComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ChargingComplete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RemainingTimeToFullSoC" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="RemainingTimeToBulkSoC" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVTargetVoltage" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentDemandReqType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "dcevStatus",
    "evTargetCurrent",
    "evMaximumVoltageLimit",
    "evMaximumCurrentLimit",
    "evMaximumPowerLimit",
    "bulkChargingComplete",
    "chargingComplete",
    "remainingTimeToFullSoC",
    "remainingTimeToBulkSoC",
    "evTargetVoltage"
})
public class CurrentDemandReqType
    extends BodyBaseType
{

    @XmlElement(name = "DC_EVStatus", required = true)
    protected DCEVStatusType dcevStatus;
    @XmlElement(name = "EVTargetCurrent", required = true)
    protected PhysicalValueType evTargetCurrent;
    @XmlElement(name = "EVMaximumVoltageLimit")
    protected PhysicalValueType evMaximumVoltageLimit;
    @XmlElement(name = "EVMaximumCurrentLimit")
    protected PhysicalValueType evMaximumCurrentLimit;
    @XmlElement(name = "EVMaximumPowerLimit")
    protected PhysicalValueType evMaximumPowerLimit;
    @XmlElement(name = "BulkChargingComplete")
    protected Boolean bulkChargingComplete;
    @XmlElement(name = "ChargingComplete")
    protected boolean chargingComplete;
    @XmlElement(name = "RemainingTimeToFullSoC")
    protected PhysicalValueType remainingTimeToFullSoC;
    @XmlElement(name = "RemainingTimeToBulkSoC")
    protected PhysicalValueType remainingTimeToBulkSoC;
    @XmlElement(name = "EVTargetVoltage", required = true)
    protected PhysicalValueType evTargetVoltage;

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
     * evTargetCurrent 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVTargetCurrent() {
        return evTargetCurrent;
    }

    /**
     * evTargetCurrent 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVTargetCurrent(PhysicalValueType value) {
        this.evTargetCurrent = value;
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
     * bulkChargingComplete 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBulkChargingComplete() {
        return bulkChargingComplete;
    }

    /**
     * bulkChargingComplete 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBulkChargingComplete(Boolean value) {
        this.bulkChargingComplete = value;
    }

    /**
     * chargingComplete 속성의 값을 가져옵니다.
     * 
     */
    public boolean isChargingComplete() {
        return chargingComplete;
    }

    /**
     * chargingComplete 속성의 값을 설정합니다.
     * 
     */
    public void setChargingComplete(boolean value) {
        this.chargingComplete = value;
    }

    /**
     * remainingTimeToFullSoC 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getRemainingTimeToFullSoC() {
        return remainingTimeToFullSoC;
    }

    /**
     * remainingTimeToFullSoC 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setRemainingTimeToFullSoC(PhysicalValueType value) {
        this.remainingTimeToFullSoC = value;
    }

    /**
     * remainingTimeToBulkSoC 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getRemainingTimeToBulkSoC() {
        return remainingTimeToBulkSoC;
    }

    /**
     * remainingTimeToBulkSoC 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setRemainingTimeToBulkSoC(PhysicalValueType value) {
        this.remainingTimeToBulkSoC = value;
    }

    /**
     * evTargetVoltage 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVTargetVoltage() {
        return evTargetVoltage;
    }

    /**
     * evTargetVoltage 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVTargetVoltage(PhysicalValueType value) {
        this.evTargetVoltage = value;
    }

}
