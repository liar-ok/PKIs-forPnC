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
 * <p>EnergyTransferModeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="EnergyTransferModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AC_single_phase_core"/>
 *     &lt;enumeration value="AC_three_phase_core"/>
 *     &lt;enumeration value="DC_core"/>
 *     &lt;enumeration value="DC_extended"/>
 *     &lt;enumeration value="DC_combo_core"/>
 *     &lt;enumeration value="DC_unique"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnergyTransferModeType")
@XmlEnum
public enum EnergyTransferModeType {

    @XmlEnumValue("AC_single_phase_core")
    AC_SINGLE_PHASE_CORE("AC_single_phase_core"),
    @XmlEnumValue("AC_three_phase_core")
    AC_THREE_PHASE_CORE("AC_three_phase_core"),
    @XmlEnumValue("DC_core")
    DC_CORE("DC_core"),
    @XmlEnumValue("DC_extended")
    DC_EXTENDED("DC_extended"),
    @XmlEnumValue("DC_combo_core")
    DC_COMBO_CORE("DC_combo_core"),
    @XmlEnumValue("DC_unique")
    DC_UNIQUE("DC_unique");
    private final String value;

    EnergyTransferModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EnergyTransferModeType fromValue(String v) {
        for (EnergyTransferModeType c: EnergyTransferModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
