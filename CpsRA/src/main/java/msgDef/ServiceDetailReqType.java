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
 * <p>ServiceDetailReqType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ServiceDetailReqType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="ServiceID" type="{urn:iso:15118:2:2013:MsgDataTypes}serviceIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDetailReqType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "serviceID"
})
public class ServiceDetailReqType
    extends BodyBaseType
{

    @XmlElement(name = "ServiceID")
    @XmlSchemaType(name = "unsignedShort")
    protected int serviceID;

    /**
     * serviceID �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getServiceID() {
        return serviceID;
    }

    /**
     * serviceID �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setServiceID(int value) {
        this.serviceID = value;
    }

}
