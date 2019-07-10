//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ParameterType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ParameterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="boolValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="byteValue" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="shortValue" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="intValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="physicalValue" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="stringValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterType", propOrder = {
    "boolValue",
    "byteValue",
    "shortValue",
    "intValue",
    "physicalValue",
    "stringValue"
})
public class ParameterType {

    protected Boolean boolValue;
    protected Byte byteValue;
    protected Short shortValue;
    protected Integer intValue;
    protected PhysicalValueType physicalValue;
    protected String stringValue;
    @XmlAttribute(name = "Name", namespace = "urn:iso:15118:2:2013:MsgDataTypes", required = true)
    protected String name;

    /**
     * boolValue �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBoolValue() {
        return boolValue;
    }

    /**
     * boolValue �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBoolValue(Boolean value) {
        this.boolValue = value;
    }

    /**
     * byteValue �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getByteValue() {
        return byteValue;
    }

    /**
     * byteValue �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setByteValue(Byte value) {
        this.byteValue = value;
    }

    /**
     * shortValue �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getShortValue() {
        return shortValue;
    }

    /**
     * shortValue �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setShortValue(Short value) {
        this.shortValue = value;
    }

    /**
     * intValue �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntValue() {
        return intValue;
    }

    /**
     * intValue �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntValue(Integer value) {
        this.intValue = value;
    }

    /**
     * physicalValue �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getPhysicalValue() {
        return physicalValue;
    }

    /**
     * physicalValue �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setPhysicalValue(PhysicalValueType value) {
        this.physicalValue = value;
    }

    /**
     * stringValue �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * stringValue �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringValue(String value) {
        this.stringValue = value;
    }

    /**
     * name �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
