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
 * <p>costKindType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="costKindType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="relativePricePercentage"/>
 *     &lt;enumeration value="RenewableGenerationPercentage"/>
 *     &lt;enumeration value="CarbonDioxideEmission"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "costKindType")
@XmlEnum
public enum CostKindType {

    @XmlEnumValue("relativePricePercentage")
    RELATIVE_PRICE_PERCENTAGE("relativePricePercentage"),
    @XmlEnumValue("RenewableGenerationPercentage")
    RENEWABLE_GENERATION_PERCENTAGE("RenewableGenerationPercentage"),
    @XmlEnumValue("CarbonDioxideEmission")
    CARBON_DIOXIDE_EMISSION("CarbonDioxideEmission");
    private final String value;

    CostKindType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CostKindType fromValue(String v) {
        for (CostKindType c: CostKindType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
