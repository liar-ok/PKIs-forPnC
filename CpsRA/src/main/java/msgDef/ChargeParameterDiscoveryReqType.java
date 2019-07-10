//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ChargeParameterDiscoveryReqType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ChargeParameterDiscoveryReqType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgBody}BodyBaseType">
 *       &lt;sequence>
 *         &lt;element name="MaxEntriesSAScheduleTuple" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="RequestedEnergyTransferMode" type="{urn:iso:15118:2:2013:MsgDataTypes}EnergyTransferModeType"/>
 *         &lt;element ref="{urn:iso:15118:2:2013:MsgDataTypes}EVChargeParameter"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeParameterDiscoveryReqType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "maxEntriesSAScheduleTuple",
    "requestedEnergyTransferMode",
    "evChargeParameter"
})
public class ChargeParameterDiscoveryReqType
    extends BodyBaseType
{

    @XmlElement(name = "MaxEntriesSAScheduleTuple")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxEntriesSAScheduleTuple;
    @XmlElement(name = "RequestedEnergyTransferMode", required = true)
    @XmlSchemaType(name = "string")
    protected EnergyTransferModeType requestedEnergyTransferMode;
    @XmlElementRef(name = "EVChargeParameter", namespace = "urn:iso:15118:2:2013:MsgDataTypes", type = JAXBElement.class)
    protected JAXBElement<? extends EVChargeParameterType> evChargeParameter;

    /**
     * maxEntriesSAScheduleTuple �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxEntriesSAScheduleTuple() {
        return maxEntriesSAScheduleTuple;
    }

    /**
     * maxEntriesSAScheduleTuple �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxEntriesSAScheduleTuple(Integer value) {
        this.maxEntriesSAScheduleTuple = value;
    }

    /**
     * requestedEnergyTransferMode �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EnergyTransferModeType }
     *     
     */
    public EnergyTransferModeType getRequestedEnergyTransferMode() {
        return requestedEnergyTransferMode;
    }

    /**
     * requestedEnergyTransferMode �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyTransferModeType }
     *     
     */
    public void setRequestedEnergyTransferMode(EnergyTransferModeType value) {
        this.requestedEnergyTransferMode = value;
    }

    /**
     * evChargeParameter �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ACEVChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EVChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DCEVChargeParameterType }{@code >}
     *     
     */
    public JAXBElement<? extends EVChargeParameterType> getEVChargeParameter() {
        return evChargeParameter;
    }

    /**
     * evChargeParameter �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ACEVChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EVChargeParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DCEVChargeParameterType }{@code >}
     *     
     */
    public void setEVChargeParameter(JAXBElement<? extends EVChargeParameterType> value) {
        this.evChargeParameter = value;
    }

}
