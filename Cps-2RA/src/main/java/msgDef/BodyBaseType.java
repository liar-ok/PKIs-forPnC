//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.07.03 �ð� 05:05:42 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BodyBaseType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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
