//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BodyBaseType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BodyBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyBaseType", namespace = "urn:iso:15118:2:2013:MsgBody")
@XmlSeeAlso({
    AuthorizationResType.class,
    PaymentDetailsReqType.class,
    AuthorizationReqType.class,
    WeldingDetectionReqType.class,
    PaymentDetailsResType.class,
    WeldingDetectionResType.class,
    ChargeParameterDiscoveryResType.class,
    CertificateUpdateReqType.class,
    ChargeParameterDiscoveryReqType.class,
    PreChargeReqType.class,
    ServiceDetailResType.class,
    MeteringReceiptReqType.class,
    ServiceDetailReqType.class,
    CertificateInstallationResType.class,
    PreChargeResType.class,
    CertificateInstallationReqType.class,
    CableCheckResType.class,
    CableCheckReqType.class,
    MeteringReceiptResType.class,
    ChargingStatusReqType.class,
    ServiceDiscoveryResType.class,
    PowerDeliveryReqType.class,
    ChargingStatusResType.class,
    ServiceDiscoveryReqType.class,
    PowerDeliveryResType.class,
    SessionStopResType.class,
    SessionSetupResType.class,
    PaymentServiceSelectionResType.class,
    CertificateUpdateResType.class,
    PaymentServiceSelectionReqType.class,
    CurrentDemandReqType.class,
    CurrentDemandResType.class,
    SessionStopReqType.class,
    SessionSetupReqType.class
})
public abstract class BodyBaseType {


}
