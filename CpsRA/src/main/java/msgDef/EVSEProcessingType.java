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
 * <p>EVSEProcessingType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="EVSEProcessingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Finished"/>
 *     &lt;enumeration value="Ongoing"/>
 *     &lt;enumeration value="Ongoing_WaitingForCustomerInteraction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EVSEProcessingType")
@XmlEnum
public enum EVSEProcessingType {

    @XmlEnumValue("Finished")
    FINISHED("Finished"),
    @XmlEnumValue("Ongoing")
    ONGOING("Ongoing"),
    @XmlEnumValue("Ongoing_WaitingForCustomerInteraction")
    ONGOING_WAITING_FOR_CUSTOMER_INTERACTION("Ongoing_WaitingForCustomerInteraction");
    private final String value;

    EVSEProcessingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EVSEProcessingType fromValue(String v) {
        for (EVSEProcessingType c: EVSEProcessingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
