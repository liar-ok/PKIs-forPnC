//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MeterInfoType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
     * meterID �Ӽ��� ���� �����ɴϴ�.
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
     * meterID �Ӽ��� ���� �����մϴ�.
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
     * meterReading �Ӽ��� ���� �����ɴϴ�.
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
     * meterReading �Ӽ��� ���� �����մϴ�.
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
     * sigMeterReading �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSigMeterReading() {
        return sigMeterReading;
    }

    /**
     * sigMeterReading �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSigMeterReading(byte[] value) {
        this.sigMeterReading = value;
    }

    /**
     * meterStatus �Ӽ��� ���� �����ɴϴ�.
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
     * meterStatus �Ӽ��� ���� �����մϴ�.
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
     * tMeter �Ӽ��� ���� �����ɴϴ�.
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
     * tMeter �Ӽ��� ���� �����մϴ�.
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
