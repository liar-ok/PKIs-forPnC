//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:58 AM KST 
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
 * <p>SalesTariffType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * salesTariffID 속성의 값을 가져옵니다.
     * 
     */
    public short getSalesTariffID() {
        return salesTariffID;
    }

    /**
     * salesTariffID 속성의 값을 설정합니다.
     * 
     */
    public void setSalesTariffID(short value) {
        this.salesTariffID = value;
    }

    /**
     * salesTariffDescription 속성의 값을 가져옵니다.
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
     * salesTariffDescription 속성의 값을 설정합니다.
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
     * numEPriceLevels 속성의 값을 가져옵니다.
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
     * numEPriceLevels 속성의 값을 설정합니다.
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
     * id 속성의 값을 가져옵니다.
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
     * id 속성의 값을 설정합니다.
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
