//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ChargingStatusResType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ChargingStatusResType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{urn:iso:15118:2:2013:MsgDataTypes}responseCodeType"/>
 *         &lt;element name="EVSEID" type="{urn:iso:15118:2:2013:MsgDataTypes}evseIDType"/>
 *         &lt;element name="SAScheduleTupleID" type="{urn:iso:15118:2:2013:MsgDataTypes}SAIDType"/>
 *         &lt;element name="EVSEMaxCurrent" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="MeterInfo" type="{urn:iso:15118:2:2013:MsgDataTypes}MeterInfoType" minOccurs="0"/>
 *         &lt;element name="ReceiptRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AC_EVSEStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}AC_EVSEStatusType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargingStatusResType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "responseCode",
    "evseid",
    "saScheduleTupleID",
    "evseMaxCurrent",
    "meterInfo",
    "receiptRequired",
    "acevseStatus"
})
public class ChargingStatusResType
    extends BodyBaseType
{

    @XmlElement(name = "ResponseCode", required = true)
    @XmlSchemaType(name = "string")
    protected ResponseCodeType responseCode;
    @XmlElement(name = "EVSEID", required = true)
    protected String evseid;
    @XmlElement(name = "SAScheduleTupleID")
    @XmlSchemaType(name = "unsignedByte")
    protected short saScheduleTupleID;
    @XmlElement(name = "EVSEMaxCurrent")
    protected PhysicalValueType evseMaxCurrent;
    @XmlElement(name = "MeterInfo")
    protected MeterInfoType meterInfo;
    @XmlElement(name = "ReceiptRequired")
    protected Boolean receiptRequired;
    @XmlElement(name = "AC_EVSEStatus", required = true)
    protected ACEVSEStatusType acevseStatus;

    /**
     * responseCode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCodeType }
     *     
     */
    public ResponseCodeType getResponseCode() {
        return responseCode;
    }

    /**
     * responseCode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCodeType }
     *     
     */
    public void setResponseCode(ResponseCodeType value) {
        this.responseCode = value;
    }

    /**
     * evseid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVSEID() {
        return evseid;
    }

    /**
     * evseid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVSEID(String value) {
        this.evseid = value;
    }

    /**
     * saScheduleTupleID 속성의 값을 가져옵니다.
     * 
     */
    public short getSAScheduleTupleID() {
        return saScheduleTupleID;
    }

    /**
     * saScheduleTupleID 속성의 값을 설정합니다.
     * 
     */
    public void setSAScheduleTupleID(short value) {
        this.saScheduleTupleID = value;
    }

    /**
     * evseMaxCurrent 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaxCurrent() {
        return evseMaxCurrent;
    }

    /**
     * evseMaxCurrent 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaxCurrent(PhysicalValueType value) {
        this.evseMaxCurrent = value;
    }

    /**
     * meterInfo 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MeterInfoType }
     *     
     */
    public MeterInfoType getMeterInfo() {
        return meterInfo;
    }

    /**
     * meterInfo 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterInfoType }
     *     
     */
    public void setMeterInfo(MeterInfoType value) {
        this.meterInfo = value;
    }

    /**
     * receiptRequired 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReceiptRequired() {
        return receiptRequired;
    }

    /**
     * receiptRequired 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReceiptRequired(Boolean value) {
        this.receiptRequired = value;
    }

    /**
     * acevseStatus 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ACEVSEStatusType }
     *     
     */
    public ACEVSEStatusType getACEVSEStatus() {
        return acevseStatus;
    }

    /**
     * acevseStatus 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ACEVSEStatusType }
     *     
     */
    public void setACEVSEStatus(ACEVSEStatusType value) {
        this.acevseStatus = value;
    }

}
