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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EVSEStatusType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EVSEStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NotificationMaxDelay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="EVSENotification" type="{urn:iso:15118:2:2013:MsgDataTypes}EVSENotificationType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVSEStatusType", propOrder = {
    "notificationMaxDelay",
    "evseNotification"
})
@XmlSeeAlso({
    DCEVSEStatusType.class,
    ACEVSEStatusType.class
})
public abstract class EVSEStatusType {

    @XmlElement(name = "NotificationMaxDelay")
    @XmlSchemaType(name = "unsignedShort")
    protected int notificationMaxDelay;
    @XmlElement(name = "EVSENotification", required = true)
    @XmlSchemaType(name = "string")
    protected EVSENotificationType evseNotification;

    /**
     * notificationMaxDelay �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getNotificationMaxDelay() {
        return notificationMaxDelay;
    }

    /**
     * notificationMaxDelay �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setNotificationMaxDelay(int value) {
        this.notificationMaxDelay = value;
    }

    /**
     * evseNotification �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EVSENotificationType }
     *     
     */
    public EVSENotificationType getEVSENotification() {
        return evseNotification;
    }

    /**
     * evseNotification �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EVSENotificationType }
     *     
     */
    public void setEVSENotification(EVSENotificationType value) {
        this.evseNotification = value;
    }

}
