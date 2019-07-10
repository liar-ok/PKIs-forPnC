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
 * <p>DC_EVSEStatusType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="DC_EVSEStatusType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVSEStatusType">
 *       &lt;sequence>
 *         &lt;element name="EVSEIsolationStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}isolationLevelType" minOccurs="0"/>
 *         &lt;element name="EVSEStatusCode" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVSEStatusCodeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DC_EVSEStatusType", propOrder = {
    "evseIsolationStatus",
    "evseStatusCode"
})
public class DCEVSEStatusType
    extends EVSEStatusType
{

    @XmlElement(name = "EVSEIsolationStatus")
    @XmlSchemaType(name = "string")
    protected IsolationLevelType evseIsolationStatus;
    @XmlElement(name = "EVSEStatusCode", required = true)
    @XmlSchemaType(name = "string")
    protected DCEVSEStatusCodeType evseStatusCode;

    /**
     * evseIsolationStatus 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IsolationLevelType }
     *     
     */
    public IsolationLevelType getEVSEIsolationStatus() {
        return evseIsolationStatus;
    }

    /**
     * evseIsolationStatus 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IsolationLevelType }
     *     
     */
    public void setEVSEIsolationStatus(IsolationLevelType value) {
        this.evseIsolationStatus = value;
    }

    /**
     * evseStatusCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DCEVSEStatusCodeType }
     *     
     */
    public DCEVSEStatusCodeType getEVSEStatusCode() {
        return evseStatusCode;
    }

    /**
     * evseStatusCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DCEVSEStatusCodeType }
     *     
     */
    public void setEVSEStatusCode(DCEVSEStatusCodeType value) {
        this.evseStatusCode = value;
    }

}
