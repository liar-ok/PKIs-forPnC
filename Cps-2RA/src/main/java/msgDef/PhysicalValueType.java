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
 * <p>PhysicalValueType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
     * multiplier �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public byte getMultiplier() {
        return multiplier;
    }

    /**
     * multiplier �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setMultiplier(byte value) {
        this.multiplier = value;
    }

    /**
     * unit �Ӽ��� ���� �����ɴϴ�.
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
     * unit �Ӽ��� ���� �����մϴ�.
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
     * value �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * value �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

}
