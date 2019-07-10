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
 * <p>DC_EVErrorCodeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
