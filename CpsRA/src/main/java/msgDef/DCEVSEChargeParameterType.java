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
 * <p>DC_EVSEChargeParameterType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * dcevseStatus 속성의 값을 가져옵니다.
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
     * dcevseStatus 속성의 값을 설정합니다.
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
     * evseMaximumCurrentLimit 속성의 값을 가져옵니다.
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
     * evseMaximumCurrentLimit 속성의 값을 설정합니다.
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
     * evseMaximumPowerLimit 속성의 값을 가져옵니다.
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
     * evseMaximumPowerLimit 속성의 값을 설정합니다.
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
     * evseMaximumVoltageLimit 속성의 값을 가져옵니다.
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
     * evseMaximumVoltageLimit 속성의 값을 설정합니다.
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
     * evseMinimumCurrentLimit 속성의 값을 가져옵니다.
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
     * evseMinimumCurrentLimit 속성의 값을 설정합니다.
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
     * evseMinimumVoltageLimit 속성의 값을 가져옵니다.
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
     * evseMinimumVoltageLimit 속성의 값을 설정합니다.
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
     * evseCurrentRegulationTolerance 속성의 값을 가져옵니다.
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
     * evseCurrentRegulationTolerance 속성의 값을 설정합니다.
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
     * evsePeakCurrentRipple 속성의 값을 가져옵니다.
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
     * evsePeakCurrentRipple 속성의 값을 설정합니다.
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
     * evseEnergyToBeDelivered 속성의 값을 가져옵니다.
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
     * evseEnergyToBeDelivered 속성의 값을 설정합니다.
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
