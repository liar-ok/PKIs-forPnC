//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SAScheduleTupleType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="SAScheduleTupleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SAScheduleTupleID" type="{urn:iso:15118:2:2013:MsgDataTypes}SAIDType"/>
 *         &lt;element name="PMaxSchedule" type="{urn:iso:15118:2:2013:MsgDataTypes}PMaxScheduleType"/>
 *         &lt;element name="SalesTariff" type="{urn:iso:15118:2:2013:MsgDataTypes}SalesTariffType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAScheduleTupleType", propOrder = {
    "saScheduleTupleID",
    "pMaxSchedule",
    "salesTariff"
})
public class SAScheduleTupleType {

    @XmlElement(name = "SAScheduleTupleID")
    @XmlSchemaType(name = "unsignedByte")
    protected short saScheduleTupleID;
    @XmlElement(name = "PMaxSchedule", required = true)
    protected PMaxScheduleType pMaxSchedule;
    @XmlElement(name = "SalesTariff")
    protected SalesTariffType salesTariff;

    /**
     * saScheduleTupleID 속성의 값을 가져옵니다.
     * 
     */
    public short getSAScheduleTupleID() {
        return saScheduleTupleID;
    }

    /**
     * saScheduleTupleID 속성의 값을 설정합니다.
     * 
     */
    public void setSAScheduleTupleID(short value) {
        this.saScheduleTupleID = value;
    }

    /**
     * pMaxSchedule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PMaxScheduleType }
     *     
     */
    public PMaxScheduleType getPMaxSchedule() {
        return pMaxSchedule;
    }

    /**
     * pMaxSchedule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PMaxScheduleType }
     *     
     */
    public void setPMaxSchedule(PMaxScheduleType value) {
        this.pMaxSchedule = value;
    }

    /**
     * salesTariff 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SalesTariffType }
     *     
     */
    public SalesTariffType getSalesTariff() {
        return salesTariff;
    }

    /**
     * salesTariff 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesTariffType }
     *     
     */
    public void setSalesTariff(SalesTariffType value) {
        this.salesTariff = value;
    }

}
