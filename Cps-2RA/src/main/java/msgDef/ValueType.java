//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>valueType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="valueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bool"/>
 *     &lt;enumeration value="byte"/>
 *     &lt;enumeration value="short"/>
 *     &lt;enumeration value="int"/>
 *     &lt;enumeration value="physicalValue"/>
 *     &lt;enumeration value="string"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "valueType")
@XmlEnum
public enum ValueType {

    @XmlEnumValue("bool")
    BOOL("bool"),
    @XmlEnumValue("byte")
    BYTE("byte"),
    @XmlEnumValue("short")
    SHORT("short"),
    @XmlEnumValue("int")
    INT("int"),
    @XmlEnumValue("physicalValue")
    PHYSICAL_VALUE("physicalValue"),
    @XmlEnumValue("string")
    STRING("string");
    private final String value;

    ValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValueType fromValue(String v) {
        for (ValueType c: ValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
