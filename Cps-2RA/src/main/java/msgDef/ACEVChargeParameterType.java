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
 * <p>AC_EVChargeParameterType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * eAmount 속성의 값을 가져옵니다.
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
     * eAmount 속성의 값을 설정합니다.
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
     * evMaxVoltage 속성의 값을 가져옵니다.
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
     * evMaxVoltage 속성의 값을 설정합니다.
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
     * evMaxCurrent 속성의 값을 가져옵니다.
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
     * evMaxCurrent 속성의 값을 설정합니다.
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
     * evMinCurrent 속성의 값을 가져옵니다.
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
     * evMinCurrent 속성의 값을 설정합니다.
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
