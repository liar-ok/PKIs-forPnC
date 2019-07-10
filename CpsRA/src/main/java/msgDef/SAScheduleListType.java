//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:58 AM KST 
//


package msgDef;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SAScheduleListType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="SAScheduleListType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}SASchedulesType">
 *       &lt;sequence>
 *         &lt;element name="SAScheduleTuple" type="{urn:iso:15118:2:2013:MsgDataTypes}SAScheduleTupleType" maxOccurs="3"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAScheduleListType", propOrder = {
    "saScheduleTuple"
})
public class SAScheduleListType
    extends SASchedulesType
{

    @XmlElement(name = "SAScheduleTuple", required = true)
    protected List<SAScheduleTupleType> saScheduleTuple;

    /**
     * Gets the value of the saScheduleTuple property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saScheduleTuple property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAScheduleTuple().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAScheduleTupleType }
     * 
     * 
     */
    public List<SAScheduleTupleType> getSAScheduleTuple() {
        if (saScheduleTuple == null) {
            saScheduleTuple = new ArrayList<SAScheduleTupleType>();
        }
        return this.saScheduleTuple;
    }

}
