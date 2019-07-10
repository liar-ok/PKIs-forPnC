package kr.ac.hmcl.mju.CpsSubCA1;


import java.util.List;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import kr.ac.hmcl.mju.CpsSubCA1.PkiMsg.PkiMsgFormat;
import kr.ac.hmcl.mju.CpsSubCA1.ReqToIssueCert.ReqToIssueCertFormat;
import kr.ac.hmcl.mju.CpsSubCA1.ResWithCert.CertInfo;
import kr.ac.hmcl.mju.CpsSubCA1.ResWithCert.ResWithCertFormat;


public class PBMessage {
	public PkiMsgFormat getPkiMsg(byte[] getData) {
		PkiMsgFormat pkiMsg = null;		
		try {
			pkiMsg = PkiMsgFormat.parseFrom(getData);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pkiMsg;
	}
	
	public byte[] setPkiMsg(String type, byte[] payload) {
		PkiMsgFormat pkiMsg;
		ByteString payloadByteString;
		payloadByteString = ByteString.copyFrom(payload);
		
		pkiMsg = PkiMsgFormat.newBuilder().setType(type)
				.setPayload(payloadByteString)
				.build();
		byte[] sendData = pkiMsg.toByteArray();
		return sendData;
	}
	
	public ReqToIssueCertFormat getReqToIssueCert(PkiMsgFormat pkiMsg) {
		ReqToIssueCertFormat reqToIssueCert = null;
		try {
			reqToIssueCert = ReqToIssueCertFormat.parseFrom(pkiMsg.getPayload().toByteArray());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqToIssueCert;
	}
	
	public byte[] setReqToIssueCert(byte[] subjectCsrFile, String subjectCertName) {
		ReqToIssueCertFormat reqToIssueCert = null;
		ByteString subjectCsrFileByteString;
		subjectCsrFileByteString = ByteString.copyFrom(subjectCsrFile);
		
		reqToIssueCert = ReqToIssueCertFormat.newBuilder().setSubjectCsrFile(subjectCsrFileByteString)
				.setSubjectCertName(subjectCertName)
				.build();
		byte[] sendData = reqToIssueCert.toByteArray();
		return sendData;
	}
	
	public ResWithCertFormat getResWithCert(PkiMsgFormat pkiMsg) {
		ResWithCertFormat resWithCert = null;
		try {
			resWithCert = ResWithCertFormat.parseFrom(pkiMsg.getPayload().toByteArray());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resWithCert;
	}

	public byte[] setResWithCert(List<CertInfo> certInfoList) {
		ResWithCertFormat resWithCert = null;
		ResWithCertFormat.Builder builder = ResWithCertFormat.newBuilder();
		System.out.println("certInfoList.size is" + certInfoList.size());
		for (int i=0; i<certInfoList.size();i++) {
			System.out.println("index count : " + i);
			builder.addCertInfo(i, certInfoList.get(i));
		}
		resWithCert= builder.build();
		byte[] sendData = resWithCert.toByteArray();
		return sendData;
	}
	
	public CertInfo setCertInfo(byte[] certFile, String certFileName) {
		CertInfo certInfo = null;
		ByteString certFileBS;
		certFileBS = ByteString.copyFrom(certFile);
		certInfo = CertInfo.newBuilder().setCertFile(certFileBS)
				.setCertFileName(certFileName).build();
		return certInfo;
	}
	
}
