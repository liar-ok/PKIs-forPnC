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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>SalesTariffType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="SalesTariffType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesTariffID" type="{urn:iso:15118:2:2013:MsgDataTypes}SAIDType"/>
 *         &lt;element name="SalesTariffDescription" type="{urn:iso:15118:2:2013:MsgDataTypes}tariffDescriptionType" minOccurs="0"/>
 *         &lt;element name="NumEPriceLevels" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element ref="{urn:iso:15118:2:2013:MsgDataTypes}SalesTariffEntry" maxOccurs="1024"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesTariffType", propOrder = {
    "salesTariffID",
    "salesTariffDescription",
    "numEPriceLevels",
    "salesTariffEntry"
})
public class SalesTariffType {

    @XmlElement(name = "SalesTariffID")
    @XmlSchemaType(name = "unsignedByte")
    protected short salesTariffID;
    @XmlElement(name = "SalesTariffDescription")
    protected String salesTariffDescription;
    @XmlElement(name = "NumEPriceLevels")
    @XmlSchemaType(name = "unsignedByte")
    protected Short numEPriceLevels;
    @XmlElement(name = "SalesTariffEntry", required = true)
    protected List<SalesTariffEntryType> salesTariffEntry;
    @XmlAttribute(name = "Id", namespace = "urn:iso:15118:2:2013:MsgDataTypes")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * salesTariffID �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public short getSalesTariffID() {
        return salesTariffID;
    }

    /**
     * salesTariffID �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setSalesTariffID(short value) {
        this.salesTariffID = value;
    }

    /**
     * salesTariffDescription �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesTariffDescription() {
        return salesTariffDescription;
    }

    /**
     * salesTariffDescription �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesTariffDescription(String value) {
        this.salesTariffDescription = value;
    }

    /**
     * numEPriceLevels �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumEPriceLevels() {
        return numEPriceLevels;
    }

    /**
     * numEPriceLevels �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumEPriceLevels(Short value) {
        this.numEPriceLevels = value;
    }

    /**
     * Gets the value of the salesTariffEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesTariffEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesTariffEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesTariffEntryType }
     * 
     * 
     */
    public List<SalesTariffEntryType> getSalesTariffEntry() {
        if (salesTariffEntry == null) {
            salesTariffEntry = new ArrayList<SalesTariffEntryType>();
        }
        return this.salesTariffEntry;
    }

    /**
     * id �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * id �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
