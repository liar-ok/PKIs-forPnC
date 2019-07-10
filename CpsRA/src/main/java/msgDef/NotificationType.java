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
 * <p>NotificationType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="NotificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FaultCode" type="{urn:iso:15118:2:2013:MsgDataTypes}faultCodeType"/>
 *         &lt;element name="FaultMsg" type="{urn:iso:15118:2:2013:MsgDataTypes}faultMsgType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationType", propOrder = {
    "faultCode",
    "faultMsg"
})
public class NotificationType {

    @XmlElement(name = "FaultCode", required = true)
    @XmlSchemaType(name = "string")
    protected FaultCodeType faultCode;
    @XmlElement(name = "FaultMsg")
    protected String faultMsg;

    /**
     * faultCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FaultCodeType }
     *     
     */
    public FaultCodeType getFaultCode() {
        return faultCode;
    }

    /**
     * faultCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultCodeType }
     *     
     */
    public void setFaultCode(FaultCodeType value) {
        this.faultCode = value;
    }

    /**
     * faultMsg 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultMsg() {
        return faultMsg;
    }

    /**
     * faultMsg 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultMsg(String value) {
        this.faultMsg = value;
    }

}
