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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ServiceType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * serviceID 속성의 값을 가져옵니다.
     * 
     */
    public int getServiceID() {
        return serviceID;
    }

    /**
     * serviceID 속성의 값을 설정합니다.
     * 
     */
    public void setServiceID(int value) {
        this.serviceID = value;
    }

    /**
     * serviceName 속성의 값을 가져옵니다.
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
     * serviceName 속성의 값을 설정합니다.
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
     * serviceCategory 속성의 값을 가져옵니다.
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
     * serviceCategory 속성의 값을 설정합니다.
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
     * serviceScope 속성의 값을 가져옵니다.
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
     * serviceScope 속성의 값을 설정합니다.
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
     * freeService 속성의 값을 가져옵니다.
     * 
     */
    public boolean isFreeService() {
        return freeService;
    }

    /**
     * freeService 속성의 값을 설정합니다.
     * 
     */
    public void setFreeService(boolean value) {
        this.freeService = value;
    }

}
