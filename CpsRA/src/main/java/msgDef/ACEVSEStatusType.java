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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AC_EVSEStatusType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="AC_EVSEStatusType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVSEStatusType">
 *       &lt;sequence>
 *         &lt;element name="RCD" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AC_EVSEStatusType", propOrder = {
    "rcd"
})
public class ACEVSEStatusType
    extends EVSEStatusType
{

    @XmlElement(name = "RCD")
    protected boolean rcd;

    /**
     * rcd �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public boolean isRCD() {
        return rcd;
    }

    /**
     * rcd �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setRCD(boolean value) {
        this.rcd = value;
    }

}
