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
 * <p>EnergyTransferModeType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
