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
 * <p>AC_EVSEChargeParameterType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="AC_EVSEChargeParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVSEChargeParameterType">
 *       &lt;sequence>
 *         &lt;element name="AC_EVSEStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}AC_EVSEStatusType"/>
 *         &lt;element name="EVSENominalVoltage" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMaxCurrent" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AC_EVSEChargeParameterType", propOrder = {
    "acevseStatus",
    "evseNominalVoltage",
    "evseMaxCurrent"
})
public class ACEVSEChargeParameterType
    extends EVSEChargeParameterType
{

    @XmlElement(name = "AC_EVSEStatus", required = true)
    protected ACEVSEStatusType acevseStatus;
    @XmlElement(name = "EVSENominalVoltage", required = true)
    protected PhysicalValueType evseNominalVoltage;
    @XmlElement(name = "EVSEMaxCurrent", required = true)
    protected PhysicalValueType evseMaxCurrent;

    /**
     * acevseStatus 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ACEVSEStatusType }
     *     
     */
    public ACEVSEStatusType getACEVSEStatus() {
        return acevseStatus;
    }

    /**
     * acevseStatus 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ACEVSEStatusType }
     *     
     */
    public void setACEVSEStatus(ACEVSEStatusType value) {
        this.acevseStatus = value;
    }

    /**
     * evseNominalVoltage 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSENominalVoltage() {
        return evseNominalVoltage;
    }

    /**
     * evseNominalVoltage 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSENominalVoltage(PhysicalValueType value) {
        this.evseNominalVoltage = value;
    }

    /**
     * evseMaxCurrent 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaxCurrent() {
        return evseMaxCurrent;
    }

    /**
     * evseMaxCurrent 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaxCurrent(PhysicalValueType value) {
        this.evseMaxCurrent = value;
    }

}
