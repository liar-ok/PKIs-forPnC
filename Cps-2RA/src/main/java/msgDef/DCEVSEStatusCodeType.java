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
 * <p>DC_EVSEStatusCodeType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="DC_EVSEStatusCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EVSE_NotReady"/>
 *     &lt;enumeration value="EVSE_Ready"/>
 *     &lt;enumeration value="EVSE_Shutdown"/>
 *     &lt;enumeration value="EVSE_UtilityInterruptEvent"/>
 *     &lt;enumeration value="EVSE_IsolationMonitoringActive"/>
 *     &lt;enumeration value="EVSE_EmergencyShutdown"/>
 *     &lt;enumeration value="EVSE_Malfunction"/>
 *     &lt;enumeration value="Reserved_8"/>
 *     &lt;enumeration value="Reserved_9"/>
 *     &lt;enumeration value="Reserved_A"/>
 *     &lt;enumeration value="Reserved_B"/>
 *     &lt;enumeration value="Reserved_C"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DC_EVSEStatusCodeType")
@XmlEnum
public enum DCEVSEStatusCodeType {

    @XmlEnumValue("EVSE_NotReady")
    EVSE_NOT_READY("EVSE_NotReady"),
    @XmlEnumValue("EVSE_Ready")
    EVSE_READY("EVSE_Ready"),
    @XmlEnumValue("EVSE_Shutdown")
    EVSE_SHUTDOWN("EVSE_Shutdown"),
    @XmlEnumValue("EVSE_UtilityInterruptEvent")
    EVSE_UTILITY_INTERRUPT_EVENT("EVSE_UtilityInterruptEvent"),
    @XmlEnumValue("EVSE_IsolationMonitoringActive")
    EVSE_ISOLATION_MONITORING_ACTIVE("EVSE_IsolationMonitoringActive"),
    @XmlEnumValue("EVSE_EmergencyShutdown")
    EVSE_EMERGENCY_SHUTDOWN("EVSE_EmergencyShutdown"),
    @XmlEnumValue("EVSE_Malfunction")
    EVSE_MALFUNCTION("EVSE_Malfunction"),
    @XmlEnumValue("Reserved_8")
    RESERVED_8("Reserved_8"),
    @XmlEnumValue("Reserved_9")
    RESERVED_9("Reserved_9"),
    @XmlEnumValue("Reserved_A")
    RESERVED_A("Reserved_A"),
    @XmlEnumValue("Reserved_B")
    RESERVED_B("Reserved_B"),
    @XmlEnumValue("Reserved_C")
    RESERVED_C("Reserved_C");
    private final String value;

    DCEVSEStatusCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DCEVSEStatusCodeType fromValue(String v) {
        for (DCEVSEStatusCodeType c: DCEVSEStatusCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
