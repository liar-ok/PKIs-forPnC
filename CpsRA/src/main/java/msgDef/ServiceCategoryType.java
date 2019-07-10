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
 * <p>serviceCategoryType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="serviceCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EVCharging"/>
 *     &lt;enumeration value="Internet"/>
 *     &lt;enumeration value="ContractCertificate"/>
 *     &lt;enumeration value="OtherCustom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "serviceCategoryType")
@XmlEnum
public enum ServiceCategoryType {

    @XmlEnumValue("EVCharging")
    EV_CHARGING("EVCharging"),
    @XmlEnumValue("Internet")
    INTERNET("Internet"),
    @XmlEnumValue("ContractCertificate")
    CONTRACT_CERTIFICATE("ContractCertificate"),
    @XmlEnumValue("OtherCustom")
    OTHER_CUSTOM("OtherCustom");
    private final String value;

    ServiceCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceCategoryType fromValue(String v) {
        for (ServiceCategoryType c: ServiceCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
