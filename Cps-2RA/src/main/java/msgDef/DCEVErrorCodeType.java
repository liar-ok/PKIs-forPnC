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
 * <p>DC_EVErrorCodeType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="DC_EVErrorCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO_ERROR"/>
 *     &lt;enumeration value="FAILED_RESSTemperatureInhibit"/>
 *     &lt;enumeration value="FAILED_EVShiftPosition"/>
 *     &lt;enumeration value="FAILED_ChargerConnectorLockFault"/>
 *     &lt;enumeration value="FAILED_EVRESSMalfunction"/>
 *     &lt;enumeration value="FAILED_ChargingCurrentdifferential"/>
 *     &lt;enumeration value="FAILED_ChargingVoltageOutOfRange"/>
 *     &lt;enumeration value="Reserved_A"/>
 *     &lt;enumeration value="Reserved_B"/>
 *     &lt;enumeration value="Reserved_C"/>
 *     &lt;enumeration value="FAILED_ChargingSystemIncompatibility"/>
 *     &lt;enumeration value="NoData"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DC_EVErrorCodeType")
@XmlEnum
public enum DCEVErrorCodeType {

    NO_ERROR("NO_ERROR"),
    @XmlEnumValue("FAILED_RESSTemperatureInhibit")
    FAILED_RESS_TEMPERATURE_INHIBIT("FAILED_RESSTemperatureInhibit"),
    @XmlEnumValue("FAILED_EVShiftPosition")
    FAILED_EV_SHIFT_POSITION("FAILED_EVShiftPosition"),
    @XmlEnumValue("FAILED_ChargerConnectorLockFault")
    FAILED_CHARGER_CONNECTOR_LOCK_FAULT("FAILED_ChargerConnectorLockFault"),
    @XmlEnumValue("FAILED_EVRESSMalfunction")
    FAILED_EVRESS_MALFUNCTION("FAILED_EVRESSMalfunction"),
    @XmlEnumValue("FAILED_ChargingCurrentdifferential")
    FAILED_CHARGING_CURRENTDIFFERENTIAL("FAILED_ChargingCurrentdifferential"),
    @XmlEnumValue("FAILED_ChargingVoltageOutOfRange")
    FAILED_CHARGING_VOLTAGE_OUT_OF_RANGE("FAILED_ChargingVoltageOutOfRange"),
    @XmlEnumValue("Reserved_A")
    RESERVED_A("Reserved_A"),
    @XmlEnumValue("Reserved_B")
    RESERVED_B("Reserved_B"),
    @XmlEnumValue("Reserved_C")
    RESERVED_C("Reserved_C"),
    @XmlEnumValue("FAILED_ChargingSystemIncompatibility")
    FAILED_CHARGING_SYSTEM_INCOMPATIBILITY("FAILED_ChargingSystemIncompatibility"),
    @XmlEnumValue("NoData")
    NO_DATA("NoData");
    private final String value;

    DCEVErrorCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DCEVErrorCodeType fromValue(String v) {
        for (DCEVErrorCodeType c: DCEVErrorCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
