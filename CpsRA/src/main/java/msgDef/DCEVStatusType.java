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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DC_EVStatusType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
     * evReady �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public boolean isEVReady() {
        return evReady;
    }

    /**
     * evReady �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setEVReady(boolean value) {
        this.evReady = value;
    }

    /**
     * evErrorCode �Ӽ��� ���� �����ɴϴ�.
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
     * evErrorCode �Ӽ��� ���� �����մϴ�.
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
     * evresssoc �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public byte getEVRESSSOC() {
        return evresssoc;
    }

    /**
     * evresssoc �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setEVRESSSOC(byte value) {
        this.evresssoc = value;
    }

}
