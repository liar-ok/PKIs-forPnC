//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SalesTariffEntryType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="SalesTariffEntryType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EntryType">
 *       &lt;sequence>
 *         &lt;element name="EPriceLevel" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="ConsumptionCost" type="{urn:iso:15118:2:2013:MsgDataTypes}ConsumptionCostType" maxOccurs="3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesTariffEntryType", propOrder = {
    "ePriceLevel",
    "consumptionCost"
})
public class SalesTariffEntryType
    extends EntryType
{

    @XmlElement(name = "EPriceLevel")
    @XmlSchemaType(name = "unsignedByte")
    protected Short ePriceLevel;
    @XmlElement(name = "ConsumptionCost")
    protected List<ConsumptionCostType> consumptionCost;

    /**
     * ePriceLevel �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getEPriceLevel() {
        return ePriceLevel;
    }

    /**
     * ePriceLevel �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setEPriceLevel(Short value) {
        this.ePriceLevel = value;
    }

    /**
     * Gets the value of the consumptionCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionCostType }
     * 
     * 
     */
    public List<ConsumptionCostType> getConsumptionCost() {
        if (consumptionCost == null) {
            consumptionCost = new ArrayList<ConsumptionCostType>();
        }
        return this.consumptionCost;
    }

}
