//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:58 AM KST 
//


package msgDef;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MeterInfoType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="MeterInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeterID" type="{urn:iso:15118:2:2013:MsgDataTypes}meterIDType"/>
 *         &lt;element name="MeterReading" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
 *         &lt;element name="SigMeterReading" type="{urn:iso:15118:2:2013:MsgDataTypes}sigMeterReadingType" minOccurs="0"/>
 *         &lt;element name="MeterStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}meterStatusType" minOccurs="0"/>
 *         &lt;element name="TMeter" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterInfoType", propOrder = {
    "meterID",
    "meterReading",
    "sigMeterReading",
    "meterStatus",
    "tMeter"
})
public class MeterInfoType {

    @XmlElement(name = "MeterID", required = true)
    protected String meterID;
    @XmlElement(name = "MeterReading")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger meterReading;
    @XmlElement(name = "SigMeterReading")
    protected byte[] sigMeterReading;
    @XmlElement(name = "MeterStatus")
    protected Short meterStatus;
    @XmlElement(name = "TMeter")
    protected Long tMeter;

    /**
     * meterID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterID() {
        return meterID;
    }

    /**
     * meterID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterID(String value) {
        this.meterID = value;
    }

    /**
     * meterReading 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMeterReading() {
        return meterReading;
    }

    /**
     * meterReading 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMeterReading(BigInteger value) {
        this.meterReading = value;
    }

    /**
     * sigMeterReading 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSigMeterReading() {
        return sigMeterReading;
    }

    /**
     * sigMeterReading 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSigMeterReading(byte[] value) {
        this.sigMeterReading = value;
    }

    /**
     * meterStatus 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMeterStatus() {
        return meterStatus;
    }

    /**
     * meterStatus 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMeterStatus(Short value) {
        this.meterStatus = value;
    }

    /**
     * tMeter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTMeter() {
        return tMeter;
    }

    /**
     * tMeter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTMeter(Long value) {
        this.tMeter = value;
    }

}
