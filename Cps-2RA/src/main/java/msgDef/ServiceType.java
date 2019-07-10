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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ServiceType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceID" type="{urn:iso:15118:2:2013:MsgDataTypes}serviceIDType"/>
 *         &lt;element name="ServiceName" type="{urn:iso:15118:2:2013:MsgDataTypes}serviceNameType" minOccurs="0"/>
 *         &lt;element name="ServiceCategory" type="{urn:iso:15118:2:2013:MsgDataTypes}serviceCategoryType"/>
 *         &lt;element name="ServiceScope" type="{urn:iso:15118:2:2013:MsgDataTypes}serviceScopeType" minOccurs="0"/>
 *         &lt;element name="FreeService" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceType", propOrder = {
    "serviceID",
    "serviceName",
    "serviceCategory",
    "serviceScope",
    "freeService"
})
@XmlSeeAlso({
    ChargeServiceType.class
})
public class ServiceType {

    @XmlElement(name = "ServiceID")
    @XmlSchemaType(name = "unsignedShort")
    protected int serviceID;
    @XmlElement(name = "ServiceName")
    protected String serviceName;
    @XmlElement(name = "ServiceCategory", required = true)
    @XmlSchemaType(name = "string")
    protected ServiceCategoryType serviceCategory;
    @XmlElement(name = "ServiceScope")
    protected String serviceScope;
    @XmlElement(name = "FreeService")
    protected boolean freeService;

    /**
     * serviceID �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getServiceID() {
        return serviceID;
    }

    /**
     * serviceID �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setServiceID(int value) {
        this.serviceID = value;
    }

    /**
     * serviceName �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * serviceName �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * serviceCategory �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCategoryType }
     *     
     */
    public ServiceCategoryType getServiceCategory() {
        return serviceCategory;
    }

    /**
     * serviceCategory �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCategoryType }
     *     
     */
    public void setServiceCategory(ServiceCategoryType value) {
        this.serviceCategory = value;
    }

    /**
     * serviceScope �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceScope() {
        return serviceScope;
    }

    /**
     * serviceScope �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceScope(String value) {
        this.serviceScope = value;
    }

    /**
     * freeService �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public boolean isFreeService() {
        return freeService;
    }

    /**
     * freeService �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setFreeService(boolean value) {
        this.freeService = value;
    }

}
