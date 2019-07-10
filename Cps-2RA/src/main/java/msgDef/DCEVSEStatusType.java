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
 * <p>DC_EVSEStatusType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
     * evseIsolationStatus �Ӽ��� ���� �����ɴϴ�.
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
     * evseIsolationStatus �Ӽ��� ���� �����մϴ�.
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
     * evseStatusCode �Ӽ��� ���� �����ɴϴ�.
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
     * evseStatusCode �Ӽ��� ���� �����մϴ�.
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
