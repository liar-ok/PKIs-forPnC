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
 * <p>PaymentServiceSelectionReqType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="PaymentServiceSelectionReqType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="SelectedPaymentOption" type="{urn:iso:15118:2:2013:MsgDataTypes}paymentOptionType"/>
 *         &lt;element name="SelectedServiceList" type="{urn:iso:15118:2:2013:MsgDataTypes}SelectedServiceListType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentServiceSelectionReqType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "selectedPaymentOption",
    "selectedServiceList"
})
public class PaymentServiceSelectionReqType
    extends BodyBaseType
{

    @XmlElement(name = "SelectedPaymentOption", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentOptionType selectedPaymentOption;
    @XmlElement(name = "SelectedServiceList", required = true)
    protected SelectedServiceListType selectedServiceList;

    /**
     * selectedPaymentOption �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link PaymentOptionType }
     *     
     */
    public PaymentOptionType getSelectedPaymentOption() {
        return selectedPaymentOption;
    }

    /**
     * selectedPaymentOption �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentOptionType }
     *     
     */
    public void setSelectedPaymentOption(PaymentOptionType value) {
        this.selectedPaymentOption = value;
    }

    /**
     * selectedServiceList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link SelectedServiceListType }
     *     
     */
    public SelectedServiceListType getSelectedServiceList() {
        return selectedServiceList;
    }

    /**
     * selectedServiceList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectedServiceListType }
     *     
     */
    public void setSelectedServiceList(SelectedServiceListType value) {
        this.selectedServiceList = value;
    }

}
