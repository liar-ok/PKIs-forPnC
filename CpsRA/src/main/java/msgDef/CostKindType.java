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
 * <p>costKindType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
