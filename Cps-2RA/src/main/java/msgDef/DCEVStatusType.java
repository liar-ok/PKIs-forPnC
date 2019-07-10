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
 * <p>DC_EVStatusType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="DC_EVStatusType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVStatusType">
 *       &lt;sequence>
 *         &lt;element name="EVReady" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EVErrorCode" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVErrorCodeType"/>
 *         &lt;element name="EVRESSSOC" type="{urn:iso:15118:2:2013:MsgDataTypes}percentValueType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DC_EVStatusType", propOrder = {
    "evReady",
    "evErrorCode",
    "evresssoc"
})
public class DCEVStatusType
    extends EVStatusType
{

    @XmlElement(name = "EVReady")
    protected boolean evReady;
    @XmlElement(name = "EVErrorCode", required = true)
    @XmlSchemaType(name = "string")
    protected DCEVErrorCodeType evErrorCode;
    @XmlElement(name = "EVRESSSOC")
    protected byte evresssoc;

    /**
     * evReady 속성의 값을 가져옵니다.
     * 
     */
    public boolean isEVReady() {
        return evReady;
    }

    /**
     * evReady 속성의 값을 설정합니다.
     * 
     */
    public void setEVReady(boolean value) {
        this.evReady = value;
    }

    /**
     * evErrorCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DCEVErrorCodeType }
     *     
     */
    public DCEVErrorCodeType getEVErrorCode() {
        return evErrorCode;
    }

    /**
     * evErrorCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DCEVErrorCodeType }
     *     
     */
    public void setEVErrorCode(DCEVErrorCodeType value) {
        this.evErrorCode = value;
    }

    /**
     * evresssoc 속성의 값을 가져옵니다.
     * 
     */
    public byte getEVRESSSOC() {
        return evresssoc;
    }

    /**
     * evresssoc 속성의 값을 설정합니다.
     * 
     */
    public void setEVRESSSOC(byte value) {
        this.evresssoc = value;
    }

}
