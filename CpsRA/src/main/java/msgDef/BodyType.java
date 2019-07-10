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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BodyType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="BodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:iso:15118:2:2013:MsgBody}BodyElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyType", namespace = "urn:iso:15118:2:2013:MsgBody", propOrder = {
    "bodyElement"
})
public class BodyType {

    @XmlElementRef(name = "BodyElement", namespace = "urn:iso:15118:2:2013:MsgBody", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends BodyBaseType> bodyElement;

    /**
     * bodyElement �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PowerDeliveryReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrentDemandResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargeParameterDiscoveryReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateInstallationReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeldingDetectionResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentServiceSelectionReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentDetailsReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentServiceSelectionResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateUpdateResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionSetupReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateInstallationResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CableCheckReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargeParameterDiscoveryResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PreChargeResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDetailResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionSetupResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BodyBaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeldingDetectionReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentDetailsResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AuthorizationReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDetailReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PreChargeReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AuthorizationResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDiscoveryResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionStopResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargingStatusReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerDeliveryResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargingStatusResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrentDemandReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CableCheckResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDiscoveryReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionStopReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MeteringReceiptResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateUpdateReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MeteringReceiptReqType }{@code >}
     *     
     */
    public JAXBElement<? extends BodyBaseType> getBodyElement() {
        return bodyElement;
    }

    /**
     * bodyElement �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PowerDeliveryReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrentDemandResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargeParameterDiscoveryReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateInstallationReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeldingDetectionResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentServiceSelectionReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentDetailsReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentServiceSelectionResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateUpdateResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionSetupReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateInstallationResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CableCheckReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargeParameterDiscoveryResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PreChargeResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDetailResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionSetupResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BodyBaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeldingDetectionReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PaymentDetailsResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AuthorizationReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDetailReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PreChargeReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AuthorizationResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDiscoveryResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionStopResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargingStatusReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerDeliveryResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChargingStatusResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrentDemandReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CableCheckResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceDiscoveryReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SessionStopReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MeteringReceiptResType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CertificateUpdateReqType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MeteringReceiptReqType }{@code >}
     *     
     */
    public void setBodyElement(JAXBElement<? extends BodyBaseType> value) {
        this.bodyElement = value;
    }

}
