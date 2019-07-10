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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PhysicalValueType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="PhysicalValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Multiplier" type="{urn:iso:15118:2:2013:MsgDataTypes}unitMultiplierType"/>
 *         &lt;element name="Unit" type="{urn:iso:15118:2:2013:MsgDataTypes}unitSymbolType"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalValueType", propOrder = {
    "multiplier",
    "unit",
    "value"
})
public class PhysicalValueType {

    @XmlElement(name = "Multiplier")
    protected byte multiplier;
    @XmlElement(name = "Unit", required = true)
    @XmlSchemaType(name = "string")
    protected UnitSymbolType unit;
    @XmlElement(name = "Value")
    protected short value;

    /**
     * multiplier 속성의 값을 가져옵니다.
     * 
     */
    public byte getMultiplier() {
        return multiplier;
    }

    /**
     * multiplier 속성의 값을 설정합니다.
     * 
     */
    public void setMultiplier(byte value) {
        this.multiplier = value;
    }

    /**
     * unit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link UnitSymbolType }
     *     
     */
    public UnitSymbolType getUnit() {
        return unit;
    }

    /**
     * unit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitSymbolType }
     *     
     */
    public void setUnit(UnitSymbolType value) {
        this.unit = value;
    }

    /**
     * value 속성의 값을 가져옵니다.
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * value 속성의 값을 설정합니다.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

}
