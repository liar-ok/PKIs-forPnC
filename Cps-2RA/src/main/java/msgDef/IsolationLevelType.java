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
 * <p>isolationLevelType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="isolationLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invalid"/>
 *     &lt;enumeration value="Valid"/>
 *     &lt;enumeration value="Warning"/>
 *     &lt;enumeration value="Fault"/>
 *     &lt;enumeration value="No_IMD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "isolationLevelType")
@XmlEnum
public enum IsolationLevelType {

    @XmlEnumValue("Invalid")
    INVALID("Invalid"),
    @XmlEnumValue("Valid")
    VALID("Valid"),
    @XmlEnumValue("Warning")
    WARNING("Warning"),
    @XmlEnumValue("Fault")
    FAULT("Fault"),
    @XmlEnumValue("No_IMD")
    NO_IMD("No_IMD");
    private final String value;

    IsolationLevelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IsolationLevelType fromValue(String v) {
        for (IsolationLevelType c: IsolationLevelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
