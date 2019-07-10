//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SAScheduleTupleType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
     * saScheduleTupleID �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public short getSAScheduleTupleID() {
        return saScheduleTupleID;
    }

    /**
     * saScheduleTupleID �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setSAScheduleTupleID(short value) {
        this.saScheduleTupleID = value;
    }

    /**
     * pMaxSchedule �Ӽ��� ���� �����ɴϴ�.
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
     * pMaxSchedule �Ӽ��� ���� �����մϴ�.
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
     * salesTariff �Ӽ��� ���� �����ɴϴ�.
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
     * salesTariff �Ӽ��� ���� �����մϴ�.
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
