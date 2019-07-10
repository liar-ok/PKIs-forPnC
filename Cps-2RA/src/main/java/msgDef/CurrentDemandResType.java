//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CurrentDemandResType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="CurrentDemandResType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{urn:iso:15118:2:2013:MsgDataTypes}responseCodeType"/>
 *         &lt;element name="DC_EVSEStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVSEStatusType"/>
 *         &lt;element name="EVSEPresentVoltage" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEPresentCurrent" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSECurrentLimitAchieved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EVSEVoltageLimitAchieved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EVSEPowerLimitAchieved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EVSEMaximumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVSEMaximumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVSEMaximumPowerLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVSEID" type="{urn:iso:15118:2:2013:MsgDataTypes}evseIDType"/>
 *         &lt;element name="SAScheduleTupleID" type="{urn:iso:15118:2:2013:MsgDataTypes}SAIDType"/>
 *         &lt;element name="MeterInfo" type="{urn:iso:15118:2:2013:MsgDataTypes}MeterInfoType" minOccurs="0"/>
 *         &lt;element name="ReceiptRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentDemandResType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "responseCode",
    "dcevseStatus",
    "evsePresentVoltage",
    "evsePresentCurrent",
    "evseCurrentLimitAchieved",
    "evseVoltageLimitAchieved",
    "evsePowerLimitAchieved",
    "evseMaximumVoltageLimit",
    "evseMaximumCurrentLimit",
    "evseMaximumPowerLimit",
    "evseid",
    "saScheduleTupleID",
    "meterInfo",
    "receiptRequired"
})
public class CurrentDemandResType
    extends BodyBaseType
{

    @XmlElement(name = "ResponseCode", required = true)
    @XmlSchemaType(name = "string")
    protected ResponseCodeType responseCode;
    @XmlElement(name = "DC_EVSEStatus", required = true)
    protected DCEVSEStatusType dcevseStatus;
    @XmlElement(name = "EVSEPresentVoltage", required = true)
    protected PhysicalValueType evsePresentVoltage;
    @XmlElement(name = "EVSEPresentCurrent", required = true)
    protected PhysicalValueType evsePresentCurrent;
    @XmlElement(name = "EVSECurrentLimitAchieved")
    protected boolean evseCurrentLimitAchieved;
    @XmlElement(name = "EVSEVoltageLimitAchieved")
    protected boolean evseVoltageLimitAchieved;
    @XmlElement(name = "EVSEPowerLimitAchieved")
    protected boolean evsePowerLimitAchieved;
    @XmlElement(name = "EVSEMaximumVoltageLimit")
    protected PhysicalValueType evseMaximumVoltageLimit;
    @XmlElement(name = "EVSEMaximumCurrentLimit")
    protected PhysicalValueType evseMaximumCurrentLimit;
    @XmlElement(name = "EVSEMaximumPowerLimit")
    protected PhysicalValueType evseMaximumPowerLimit;
    @XmlElement(name = "EVSEID", required = true)
    protected String evseid;
    @XmlElement(name = "SAScheduleTupleID")
    @XmlSchemaType(name = "unsignedByte")
    protected short saScheduleTupleID;
    @XmlElement(name = "MeterInfo")
    protected MeterInfoType meterInfo;
    @XmlElement(name = "ReceiptRequired")
    protected Boolean receiptRequired;

    /**
     * responseCode �Ӽ��� ���� �����ɴϴ�.
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
     * responseCode �Ӽ��� ���� �����մϴ�.
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
     * dcevseStatus �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link DCEVSEStatusType }
     *     
     */
    public DCEVSEStatusType getDCEVSEStatus() {
        return dcevseStatus;
    }

    /**
     * dcevseStatus �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link DCEVSEStatusType }
     *     
     */
    public void setDCEVSEStatus(DCEVSEStatusType value) {
        this.dcevseStatus = value;
    }

    /**
     * evsePresentVoltage �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEPresentVoltage() {
        return evsePresentVoltage;
    }

    /**
     * evsePresentVoltage �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEPresentVoltage(PhysicalValueType value) {
        this.evsePresentVoltage = value;
    }

    /**
     * evsePresentCurrent �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEPresentCurrent() {
        return evsePresentCurrent;
    }

    /**
     * evsePresentCurrent �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEPresentCurrent(PhysicalValueType value) {
        this.evsePresentCurrent = value;
    }

    /**
     * evseCurrentLimitAchieved �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public boolean isEVSECurrentLimitAchieved() {
        return evseCurrentLimitAchieved;
    }

    /**
     * evseCurrentLimitAchieved �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setEVSECurrentLimitAchieved(boolean value) {
        this.evseCurrentLimitAchieved = value;
    }

    /**
     * evseVoltageLimitAchieved �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public boolean isEVSEVoltageLimitAchieved() {
        return evseVoltageLimitAchieved;
    }

    /**
     * evseVoltageLimitAchieved �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setEVSEVoltageLimitAchieved(boolean value) {
        this.evseVoltageLimitAchieved = value;
    }

    /**
     * evsePowerLimitAchieved �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public boolean isEVSEPowerLimitAchieved() {
        return evsePowerLimitAchieved;
    }

    /**
     * evsePowerLimitAchieved �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setEVSEPowerLimitAchieved(boolean value) {
        this.evsePowerLimitAchieved = value;
    }

    /**
     * evseMaximumVoltageLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumVoltageLimit() {
        return evseMaximumVoltageLimit;
    }

    /**
     * evseMaximumVoltageLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumVoltageLimit(PhysicalValueType value) {
        this.evseMaximumVoltageLimit = value;
    }

    /**
     * evseMaximumCurrentLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumCurrentLimit() {
        return evseMaximumCurrentLimit;
    }

    /**
     * evseMaximumCurrentLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumCurrentLimit(PhysicalValueType value) {
        this.evseMaximumCurrentLimit = value;
    }

    /**
     * evseMaximumPowerLimit �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumPowerLimit() {
        return evseMaximumPowerLimit;
    }

    /**
     * evseMaximumPowerLimit �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumPowerLimit(PhysicalValueType value) {
        this.evseMaximumPowerLimit = value;
    }

    /**
     * evseid �Ӽ��� ���� �����ɴϴ�.
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
     * evseid �Ӽ��� ���� �����մϴ�.
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
     * saScheduleTupleID �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public short getSAScheduleTupleID() {
        return saScheduleTupleID;
    }

    /**
     * saScheduleTupleID �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setSAScheduleTupleID(short value) {
        this.saScheduleTupleID = value;
    }

    /**
     * meterInfo �Ӽ��� ���� �����ɴϴ�.
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
     * meterInfo �Ӽ��� ���� �����մϴ�.
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
     * receiptRequired �Ӽ��� ���� �����ɴϴ�.
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
     * receiptRequired �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReceiptRequired(Boolean value) {
        this.receiptRequired = value;
    }

}
