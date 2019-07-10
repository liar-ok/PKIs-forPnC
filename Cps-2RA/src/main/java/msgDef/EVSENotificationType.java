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
 * <p>EVSENotificationType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="EVSENotificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="StopCharging"/>
 *     &lt;enumeration value="ReNegotiation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EVSENotificationType")
@XmlEnum
public enum EVSENotificationType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("StopCharging")
    STOP_CHARGING("StopCharging"),
    @XmlEnumValue("ReNegotiation")
    RE_NEGOTIATION("ReNegotiation");
    private final String value;

    EVSENotificationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EVSENotificationType fromValue(String v) {
        for (EVSENotificationType c: EVSENotificationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
