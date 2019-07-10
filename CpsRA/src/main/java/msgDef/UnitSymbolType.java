//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>unitSymbolType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
