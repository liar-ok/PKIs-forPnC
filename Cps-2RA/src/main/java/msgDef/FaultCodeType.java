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
 * <p>faultCodeType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="faultCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ParsingError"/>
 *     &lt;enumeration value="NoTLSRootCertificatAvailable"/>
 *     &lt;enumeration value="UnknownError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "faultCodeType")
@XmlEnum
public enum FaultCodeType {

    @XmlEnumValue("ParsingError")
    PARSING_ERROR("ParsingError"),
    @XmlEnumValue("NoTLSRootCertificatAvailable")
    NO_TLS_ROOT_CERTIFICAT_AVAILABLE("NoTLSRootCertificatAvailable"),
    @XmlEnumValue("UnknownError")
    UNKNOWN_ERROR("UnknownError");
    private final String value;

    FaultCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FaultCodeType fromValue(String v) {
        for (FaultCodeType c: FaultCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
