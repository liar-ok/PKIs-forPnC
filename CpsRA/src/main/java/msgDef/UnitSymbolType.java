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
 * <p>unitSymbolType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="unitSymbolType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="h"/>
 *     &lt;enumeration value="m"/>
 *     &lt;enumeration value="s"/>
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="V"/>
 *     &lt;enumeration value="W"/>
 *     &lt;enumeration value="Wh"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "unitSymbolType")
@XmlEnum
public enum UnitSymbolType {


    /**
     * Time in hours
     * 
     */
    @XmlEnumValue("h")
    H("h"),

    /**
     * Time in minutes
     * 
     */
    @XmlEnumValue("m")
    M("m"),

    /**
     * Time in seconds
     * 
     */
    @XmlEnumValue("s")
    S("s"),

    /**
     * Current in Ampere
     * 
     */
    A("A"),

    /**
     * Voltage in Volt
     * 
     */
    V("V"),

    /**
     * Active power in Watt
     * 
     */
    W("W"),

    /**
     * Real energy in Watt hours
     * 
     */
    @XmlEnumValue("Wh")
    WH("Wh");
    private final String value;

    UnitSymbolType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitSymbolType fromValue(String v) {
        for (UnitSymbolType c: UnitSymbolType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
