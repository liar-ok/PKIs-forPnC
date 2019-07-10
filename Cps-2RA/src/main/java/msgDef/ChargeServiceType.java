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
 * <p>ChargeServiceType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ChargeServiceType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}ServiceType">
 *       &lt;sequence>
 *         &lt;element name="SupportedEnergyTransferMode" type="{urn:iso:15118:2:2013:MsgDataTypes}SupportedEnergyTransferModeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeServiceType", propOrder = {
    "supportedEnergyTransferMode"
})
public class ChargeServiceType
    extends ServiceType
{

    @XmlElement(name = "SupportedEnergyTransferMode", required = true)
    protected SupportedEnergyTransferModeType supportedEnergyTransferMode;

    /**
     * supportedEnergyTransferMode �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link SupportedEnergyTransferModeType }
     *     
     */
    public SupportedEnergyTransferModeType getSupportedEnergyTransferMode() {
        return supportedEnergyTransferMode;
    }

    /**
     * supportedEnergyTransferMode �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedEnergyTransferModeType }
     *     
     */
    public void setSupportedEnergyTransferMode(SupportedEnergyTransferModeType value) {
        this.supportedEnergyTransferMode = value;
    }

}
