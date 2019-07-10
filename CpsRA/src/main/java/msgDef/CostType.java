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
 * <p>CostType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="CostType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="costKind" type="{urn:iso:15118:2:2013:MsgDataTypes}costKindType"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="amountMultiplier" type="{urn:iso:15118:2:2013:MsgDataTypes}unitMultiplierType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CostType", propOrder = {
    "costKind",
    "amount",
    "amountMultiplier"
})
public class CostType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CostKindType costKind;
    @XmlSchemaType(name = "unsignedInt")
    protected long amount;
    protected Byte amountMultiplier;

    /**
     * costKind �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link CostKindType }
     *     
     */
    public CostKindType getCostKind() {
        return costKind;
    }

    /**
     * costKind �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link CostKindType }
     *     
     */
    public void setCostKind(CostKindType value) {
        this.costKind = value;
    }

    /**
     * amount �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * amount �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * amountMultiplier �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getAmountMultiplier() {
        return amountMultiplier;
    }

    /**
     * amountMultiplier �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setAmountMultiplier(Byte value) {
        this.amountMultiplier = value;
    }

}
