//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BodyType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * bodyElement 속성의 값을 가져옵니다.
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
     * bodyElement 속성의 값을 설정합니다.
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
