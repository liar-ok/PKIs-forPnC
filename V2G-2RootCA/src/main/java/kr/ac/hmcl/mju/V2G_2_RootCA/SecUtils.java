package kr.ac.hmcl.mju.V2G_2_RootCA;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v2CRLBuilder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CRLConverter;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

import kr.ac.hmcl.mju.V2G_2_RootCA.PkiMsg.PkiMsgFormat;
import kr.ac.hmcl.mju.V2G_2_RootCA.ReqToIssueCert.ReqToIssueCertFormat;
import kr.ac.hmcl.mju.V2G_2_RootCA.ResWithCert.CertInfo;
import kr.ac.hmcl.mju.V2G_2_RootCA.ResWithCert.ResWithCertFormat;

public class SecUtils {
	PBMessage pbMsg = new PBMessage();
	PKCS10CertificationRequest subjectCsr = null;
	int rootCertSerial = 0;
	int sub1CertSerial = 10;
	int sub2CertSerial = 20;
	int contractCertSerial = 30;
	

	public SecUtils() {
		// add provider
		Provider bcProvider = new BouncyCastleProvider();
		Security.addProvider(bcProvider);

	}

	public KeyStore createKeyStore(char[] password) {
		KeyStore ks = null;

		try {
			ks = KeyStore.getInstance("JKS");
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ks.load(null);
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("rootKeystore.jks");
			ks.store(fos, password);
			fos.close();
			System.out.println("createKeyStore success");

		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ks;
	}

	private static KeyStore getKeyStore(InputStream keyStoreIS, String keyStorePassword, String keyStoreType) {
		KeyStore keyStore = null;
		try {
			keyStore = KeyStore.getInstance(keyStoreType);
			keyStore.load(keyStoreIS, keyStorePassword.toCharArray());
			keyStoreIS.close();
			return keyStore;
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException
				| NullPointerException e) {
			e.printStackTrace();
			System.out.println("\n" + e.getClass().getSimpleName() + " occurred while trying to load keystore");
		}

		return null;
	}

	public static KeyStore getKeyStore(String keyStorePath, String keyStorePassword) {
		FileInputStream keyStore;

		try {
			keyStore = new FileInputStream(keyStorePath);
			return getKeyStore(keyStore, keyStorePassword, "jks");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Keystore file location '" + keyStorePath + "' not found (FileNotFoundException).");
			return null;
		}
	}

	public void saveKeyIntoKeyStore(String keyStorePath, String keyStorePassword, String keyAlias, Key certPrivateKey,
			String keyPassword, Certificate[] chain) {
		KeyStore ks = null;
		ks = getKeyStore(keyStorePath, keyStorePassword);
		try {
			ks.setKeyEntry(keyAlias, certPrivateKey, keyPassword.toCharArray(), chain);
		} catch (KeyStoreException e) {
			e.printStackTrace();
			System.out.println("save key in to key store fail ");
		}

	}

	private static KeyPair generateEcKeyPair() {
		KeyPair keyPair = null;

		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA");
			ECGenParameterSpec ecParameterSpec = new ECGenParameterSpec("secp256r1");
			keyPairGenerator.initialize(ecParameterSpec, new SecureRandom());
			keyPair = keyPairGenerator.generateKeyPair();
		} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("while trying to generate ECkey pair");
		}

		return keyPair;
	}

	public void generateEcKeyPair(String privateFileName, String publicFileName) {
		KeyPair keyPair = null;
		keyPair = generateEcKeyPair();
		writePemFile(keyPair.getPrivate(), privateFileName);
		writePemFile(keyPair.getPublic(), publicFileName);

	}

	public void writePemFile(Object obj, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(new File(fileName));
			JcaPEMWriter pemWriter = new JcaPEMWriter(fileWriter);

			pemWriter.writeObject(obj);
			pemWriter.close();
			fileWriter.close();
			System.out.println("write a PEM file : " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public X509Certificate readCertificateFromFile(String fileName) {
		File file = new File(fileName);
		try {
			PEMParser pemParser = new PEMParser(new FileReader(file));
			X509CertificateHolder certificateHolder;
			certificateHolder = (X509CertificateHolder) pemParser.readObject();
			X509Certificate cert = new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider())
					.getCertificate(certificateHolder);
			pemParser.close();
			return cert;
		} catch (IOException | CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public PKCS10CertificationRequest readCsrFromFile(String fileName) {
		File file = new File(fileName);
		try {
			PEMParser pemParser = new PEMParser(new FileReader(file));
			PKCS10CertificationRequest csr = new PKCS10CertificationRequest(pemParser.readPemObject().getContent());
			pemParser.close();
			return csr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public PrivateKey readPrivateKeyFromFile(String fileName) {
		File file = new File(fileName);
		try {
			PEMParser pemParser = new PEMParser(new FileReader(file));
			Object obj = pemParser.readObject();
			PEMKeyPair pemKeyPair = (PEMKeyPair) obj;
			PrivateKeyInfo privateKeyInfo = pemKeyPair.getPrivateKeyInfo();
			pemParser.close();
			JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
			PrivateKey privKeyStruct = converter.getPrivateKey(privateKeyInfo);
			return privKeyStruct;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public PublicKey readPublicKeyFromFile(String fileName) {

		File file = new File(fileName);
		try {
			PEMParser pemParser = new PEMParser(new FileReader(file));
			Object obj = pemParser.readObject();
			SubjectPublicKeyInfo publicKeyInfo = (SubjectPublicKeyInfo) obj;
			pemParser.close();
			JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
			PublicKey publicKey = converter.getPublicKey(publicKeyInfo);
			return publicKey;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public X509CRL readCrlFromFile(String fileName) {
		File file = new File(fileName);
		try {
			PEMParser pemParser = new PEMParser(new FileReader(file));
			X509CRLHolder crlHolder;
			crlHolder = new X509CRLHolder(pemParser.readPemObject().getContent());
			X509CRL crl = new JcaX509CRLConverter().setProvider(new BouncyCastleProvider()).getCRL(crlHolder);
			pemParser.close();
			return crl;
		} catch (IOException | CRLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public PublicKey derivePublicKeyFromPrivateKey(PrivateKey privateKey) {

		KeyFactory keyFactory;
		try {
			keyFactory = KeyFactory.getInstance("ECDSA");
			ECPrivateKeySpec privSpec = keyFactory.getKeySpec(privateKey, ECPrivateKeySpec.class);
			ECPoint Q = privSpec.getParams().getG().multiply(privSpec.getD());

			ECPublicKeySpec pubSpec = new ECPublicKeySpec(Q, privSpec.getParams());
			PublicKey publicKeyGenerated = keyFactory.generatePublic(pubSpec);
			return publicKeyGenerated;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public String generateEmaid() {
		// prepare eMAID
		String eMAID = "KRMJU";
		for (int i = 0; i < 9; i++) {
			Random rnd = new Random();
			String temp = "";
			int rIndex = rnd.nextInt(2);
			if (rIndex == 1) {
				char alpa = (char) (rnd.nextInt(26) + 65);
				temp += Character.toString(alpa);
				
			} else {
				temp += rnd.nextInt(10);
			}
			eMAID += temp;
		}
		return eMAID;
	}

	public PKCS10CertificationRequest generateCsr(String privateKeyFileName, String publicKeyFileName, String Dn,
			String csrName) {
		// create DN of subject
		X500Name subject = new X500Name(Dn);
		// read private key
		PrivateKey privateKey = readPrivateKeyFromFile(privateKeyFileName);
		// read public key
		PublicKey publicKey = readPublicKeyFromFile(publicKeyFileName);
		JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withECDSA");
		PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder(subject, publicKey);

		ContentSigner signer;
		try {
			signer = csBuilder.build(privateKey);
			PKCS10CertificationRequest csr = p10Builder.build(signer);
			writePemFile(csr, csrName);
			System.out.println("generate a CSR : " + csrName);
			return csr;
		} catch (OperatorCreationException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void generateRootCertificate(String csrFileName, String issuerDn, String privateKeyFileName, String publicKeyFileName,
			String certName, int validity) {

		// prepare the information
		X500Name issuerName = new X500Name(issuerDn);
		rootCertSerial++;
		BigInteger serial = new BigInteger(Integer.toString(rootCertSerial));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, -1);
		Date from = c.getTime();
		c.add(Calendar.MONTH, validity);
		Date to = c.getTime();
		PrivateKey issuerPrivateKey = readPrivateKeyFromFile(privateKeyFileName);
		PublicKey issuerPublicKey = readPublicKeyFromFile(publicKeyFileName);
		PKCS10CertificationRequest csr = readCsrFromFile(csrFileName);
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
		PublicKey subjectPublicKey = null;
		try {
			subjectPublicKey = converter.getPublicKey(csr.getSubjectPublicKeyInfo());
		} catch (PEMException e1) {
			e1.printStackTrace();
		}

		X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(issuerName, serial, from, to,
				csr.getSubject(), csr.getSubjectPublicKeyInfo());
		// add BasicConstraints & KeyUsage & SubjectKeyIdentifier
		KeyUsage keyUsage = new KeyUsage(KeyUsage.keyCertSign | KeyUsage.cRLSign);
		try {
			certBuilder.addExtension(Extension.basicConstraints, true, new BasicConstraints(true));
			certBuilder.addExtension(Extension.keyUsage, true, keyUsage);
			certBuilder.addExtension(Extension.subjectKeyIdentifier, false,
					new JcaX509ExtensionUtils().createSubjectKeyIdentifier(subjectPublicKey));
			certBuilder.addExtension(Extension.authorityKeyIdentifier, false,
					new JcaX509ExtensionUtils().createAuthorityKeyIdentifier(issuerPublicKey));
			ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withECDSA").build(issuerPrivateKey);
			X509CertificateHolder holder = certBuilder.build(contentSigner);
			writePemFile(
					new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(holder),
					certName);
			System.out.println("generate a Certificate : " + certName);
		} catch (OperatorCreationException | CertificateException | CertIOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	public void generateSubCa1Certificate(String issuerDn, String privateKeyFileName, String publicKeyFileName,String certName, int validity) {

		// prepare the information
		X500Name issuerName = new X500Name(issuerDn);
		sub1CertSerial++;
		BigInteger serial = new BigInteger(Integer.toString(sub1CertSerial));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, -1);
		Date from = c.getTime();
		c.add(Calendar.MONTH, validity);
		Date to = c.getTime();
		PrivateKey issuerPrivateKey = readPrivateKeyFromFile(privateKeyFileName);
		PublicKey issuerPublicKey = readPublicKeyFromFile(publicKeyFileName);
		PKCS10CertificationRequest csr = subjectCsr;
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
		PublicKey subjectPublicKey = null;
		try {
			subjectPublicKey = converter.getPublicKey(csr.getSubjectPublicKeyInfo());
		} catch (PEMException e1) {
			e1.printStackTrace();
		}

		X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(issuerName, serial, from, to,
				csr.getSubject(), csr.getSubjectPublicKeyInfo());
		// add BasicConstraints & KeyUsage & SubjectKeyIdentifier
		BasicConstraints basicConstraints = new BasicConstraints(1);
		KeyUsage keyUsage = new KeyUsage(KeyUsage.keyCertSign | KeyUsage.cRLSign);
		try {
			certBuilder.addExtension(Extension.basicConstraints, true, basicConstraints);
			certBuilder.addExtension(Extension.keyUsage, true, keyUsage);
			certBuilder.addExtension(Extension.subjectKeyIdentifier, false,
					new JcaX509ExtensionUtils().createSubjectKeyIdentifier(subjectPublicKey));
			certBuilder.addExtension(Extension.authorityKeyIdentifier, false,
					new JcaX509ExtensionUtils().createAuthorityKeyIdentifier(issuerPublicKey));
			ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withECDSA").build(issuerPrivateKey);
			X509CertificateHolder holder = certBuilder.build(contentSigner);
			writePemFile(
					new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(holder),
					certName);
			System.out.println("generate a Certificate : " + certName);
		} catch (OperatorCreationException | CertificateException | CertIOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	public void generateSubCa2Certificate(String issuerDn, String privateKeyFileName, String publicKeyFileName,
			String certName, int validity) {

		// prepare the information
		X500Name issuerName = new X500Name(issuerDn);
		sub2CertSerial++;
		BigInteger serial = new BigInteger(Integer.toString(sub2CertSerial));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, -1);
		Date from = c.getTime();
		c.add(Calendar.MONTH, validity);
		Date to = c.getTime();
		PrivateKey issuerPrivateKey = readPrivateKeyFromFile(privateKeyFileName);
		PublicKey issuerPublicKey = readPublicKeyFromFile(publicKeyFileName);
		PKCS10CertificationRequest csr = subjectCsr;
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
		PublicKey subjectPublicKey = null;
		try {
			subjectPublicKey = converter.getPublicKey(csr.getSubjectPublicKeyInfo());
		} catch (PEMException e1) {
			e1.printStackTrace();
		}

		X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(issuerName, serial, from, to,
				csr.getSubject(), csr.getSubjectPublicKeyInfo());
		// add BasicConstraints & KeyUsage & SubjectKeyIdentifier
		BasicConstraints basicConstraints = new BasicConstraints(0);
		KeyUsage keyUsage = new KeyUsage(
				KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.keyCertSign | KeyUsage.cRLSign);
		try {
			certBuilder.addExtension(Extension.basicConstraints, true, basicConstraints);
			certBuilder.addExtension(Extension.keyUsage, true, keyUsage);
			certBuilder.addExtension(Extension.subjectKeyIdentifier, false,
					new JcaX509ExtensionUtils().createSubjectKeyIdentifier(subjectPublicKey));
			certBuilder.addExtension(Extension.authorityKeyIdentifier, false,
					new JcaX509ExtensionUtils().createAuthorityKeyIdentifier(issuerPublicKey));
			ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withECDSA").build(issuerPrivateKey);
			X509CertificateHolder holder = certBuilder.build(contentSigner);
			writePemFile(
					new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(holder),
					certName);
			System.out.println("generate a Certificate : " + certName);
		} catch (OperatorCreationException | CertificateException | CertIOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	public void generateLeafCertificate(String issuerDn, String privateKeyFileName, String publicKeyFileName,
			String certName, int validity) {

		// prepare the information
		X500Name issuerName = new X500Name(issuerDn);
		
		contractCertSerial++;
		BigInteger serial = new BigInteger(Integer.toString(contractCertSerial));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, -1);
		Date from = c.getTime();
		c.add(Calendar.MONTH, validity);
		Date to = c.getTime();
		PrivateKey issuerPrivateKey = readPrivateKeyFromFile(privateKeyFileName);
		PublicKey issuerPublicKey = readPublicKeyFromFile(publicKeyFileName);
		PKCS10CertificationRequest csr = subjectCsr;
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
		PublicKey subjectPublicKey = null;
		try {
			subjectPublicKey = converter.getPublicKey(csr.getSubjectPublicKeyInfo());
		} catch (PEMException e1) {
			e1.printStackTrace();
		}

		X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(issuerName, serial, from, to,
				csr.getSubject(), csr.getSubjectPublicKeyInfo());
		// add BasicConstraints & KeyUsage & SubjectKeyIdentifier
		BasicConstraints basicConstraints = new BasicConstraints(false);
		KeyUsage keyUsage = new KeyUsage(
				KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.keyEncipherment | KeyUsage.keyAgreement);
		try {
			certBuilder.addExtension(Extension.basicConstraints, true, basicConstraints);
			certBuilder.addExtension(Extension.keyUsage, true, keyUsage);
			certBuilder.addExtension(Extension.subjectKeyIdentifier, false,
					new JcaX509ExtensionUtils().createSubjectKeyIdentifier(subjectPublicKey));
			certBuilder.addExtension(Extension.authorityKeyIdentifier, false,
					new JcaX509ExtensionUtils().createAuthorityKeyIdentifier(issuerPublicKey));
			ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withECDSA").build(issuerPrivateKey);
			X509CertificateHolder holder = certBuilder.build(contentSigner);
			writePemFile(
					new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(holder),
					certName);
			System.out.println("generate a Certificate : " + certName);
		} catch (OperatorCreationException | CertificateException | CertIOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}


	public static boolean verifySignature(X509Certificate certificate, X509Certificate issuingCertificate) {
		PublicKey publicKeyForSignature = issuingCertificate.getPublicKey();

		try {
			certificate.verify(publicKeyForSignature);
			return true;
		} catch (InvalidKeyException | CertificateException | NoSuchAlgorithmException | NoSuchProviderException
				| SignatureException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean verifyValidityPeriod(X509Certificate certificate) {
		try {
			certificate.checkValidity();
			return true;
		} catch (CertificateExpiredException e) {
			e.printStackTrace();
			X500Principal subject = certificate.getSubjectX500Principal();

			System.out.println("Certificate with distinguished name '" + subject.getName()
					+ "' already expired (not after " + certificate.getNotAfter() + ")");
			return false;
		} catch (CertificateNotYetValidException e) {
			e.printStackTrace();
			X500Principal subject = certificate.getSubjectX500Principal();
			System.out.println("Certificate with distinguished name '" + subject.getName()
					+ "' not yet valid (not before " + certificate.getNotBefore() + ")");
			return false;
		}
	}

	public boolean verifyCertificate(String certName, String issuingCertName) {

		X509Certificate certificate = readCertificateFromFile(certName);
		X509Certificate issuingCertificate = readCertificateFromFile(issuingCertName);
		// check signature
		if (!verifySignature(certificate, issuingCertificate)) {
			return false;
		}
		System.out.println("signature OK");
		// check validity period
		if (!verifyValidityPeriod(certificate)) {
			return false;
		}
		System.out.println("validity Period OK");

		return true;
	}

	public boolean verifySubCA1Certificate(String certName, String issuingCertName) {

		verifyCertificate(certName, issuingCertName);

		X509Certificate certificate = readCertificateFromFile(certName);
		/*
		 * *********************************** COMMON CERTIFICATE ATTRIBUTES CHECK
		 * ***********************************
		 */

		// Check pathLenContraint (maximum number of non-self-issued intermediate
		// certificates that may follow this certificate)
		if (certificate.getBasicConstraints() != 1) {
			System.out.println("Sub-CA 1 certificate with distinguished name '"
					+ certificate.getSubjectX500Principal().getName() + "' has incorrect value for "
					+ "pathLenConstraint. Should be 1 instead of " + certificate.getBasicConstraints());
			return false;
		}
		System.out.println("pathLength OK");

		return true;
	}

	public boolean verifySubCA2Certificate(String certName, String issuingCertName) {

		verifyCertificate(certName, issuingCertName);

		X509Certificate certificate = readCertificateFromFile(certName);
		/*
		 * *********************************** COMMON CERTIFICATE ATTRIBUTES CHECK
		 * ***********************************
		 */

		// Check pathLenContraint (maximum number of non-self-issued intermediate
		// certificates that may follow this certificate)
		if (certificate.getBasicConstraints() != 0) {
			System.out.println("Sub-CA 2 certificate with distinguished name '"
					+ certificate.getSubjectX500Principal().getName() + "' has incorrect value for "
					+ "pathLenConstraint. Should be 0 instead of " + certificate.getBasicConstraints());
			return false;
		}
		System.out.println("pathLength OK");

		return true;
	}

	public byte[] makeReqToIssueCertMsg(String subjectCsrName, String subjectCertName) {
		PKCS10CertificationRequest csr = readCsrFromFile(subjectCsrName);
		try {
			byte[] payload = pbMsg.setReqToIssueCert(csr.getEncoded(), subjectCertName);
			byte[] pkiMsgBytes = pbMsg.setPkiMsg("ReqToIssueCertFormat", payload);
			return pkiMsgBytes;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public byte[] makeResWithCertMsg(List<String> certName) {
		List<CertInfo> certInfoList = new ArrayList<>();
		for (int i = 0; i < certName.size(); i++) {
			X509Certificate subjectCert = readCertificateFromFile(certName.get(i));
			CertInfo certInfo = null;
			try {
				certInfo = pbMsg.setCertInfo(subjectCert.getEncoded(), certName.get(i));
				certInfoList.add(certInfo);
			} catch (CertificateEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		byte[] payload = pbMsg.setResWithCert(certInfoList);
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("ResWithCert", payload);
		return pkiMsgBytes;
	}
	

	
	public byte[] makeReqToGetV2GRootCertMsg() {
		byte[] payload = new byte[0];
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("ReqToGetV2GRootCert", payload);
		return pkiMsgBytes;
	}
	
	public byte[] makeReqToGetMORootCertMsg() {
		byte[] payload = new byte[0];
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("ReqToGetMORootCert", payload);
		return pkiMsgBytes;
	}
	public byte[] makeFinishConnectionMsg() {
		byte[] payload = new byte[0];
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("FinishConnection", payload);
		return pkiMsgBytes;
	}

	public void generateCRL(String caCrlCertName, String privateKeyFileName, String crlFileName,
			String revokeCertFileName) {
		X509Certificate caCert = readCertificateFromFile(caCrlCertName);
		X509Certificate revokeCert = readCertificateFromFile(revokeCertFileName);
		PrivateKey caPrivateKey = readPrivateKeyFromFile(privateKeyFileName);
		X509v2CRLBuilder crlGen = new X509v2CRLBuilder(new X500Name(caCert.getSubjectDN().getName()), new Date());
		crlGen.addCRLEntry(revokeCert.getSerialNumber(), new Date(), CRLReason.privilegeWithdrawn);
		JcaContentSignerBuilder contentSignerBuilder = new JcaContentSignerBuilder("SHA256withECDSA");
		contentSignerBuilder.setProvider("BC");
		try {
			X509CRLHolder crlHolder = crlGen.build(contentSignerBuilder.build(caPrivateKey));
			JcaX509CRLConverter converter = new JcaX509CRLConverter();
			converter.setProvider("BC");
			writePemFile(converter.getCRL(crlHolder), crlFileName);
			System.out.println("generate CRL success");
		} catch (OperatorCreationException | CRLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void addCRL(String crlFileName, String privateKeyFileName, String revokeCertName) {
		X509CRL crl = readCrlFromFile(crlFileName);
		PrivateKey caPrivateKey = readPrivateKeyFromFile(privateKeyFileName);
		X509Certificate revokeCert = readCertificateFromFile(revokeCertName);
		X509v2CRLBuilder crlGen = new X509v2CRLBuilder(new X500Name(crl.getIssuerX500Principal().getName()),
				new Date());
		try {
			crlGen.addCRL(new X509CRLHolder(crl.getEncoded()));
			crlGen.addCRLEntry(revokeCert.getSerialNumber(), new Date(), CRLReason.privilegeWithdrawn);
			JcaContentSignerBuilder contentSignerBuilder = new JcaContentSignerBuilder("SHA256withECDSA");
			contentSignerBuilder.setProvider("BC");
			X509CRLHolder crlHolder = crlGen.build(contentSignerBuilder.build(caPrivateKey));
			JcaX509CRLConverter converter = new JcaX509CRLConverter();
			converter.setProvider("BC");
			writePemFile(converter.getCRL(crlHolder), crlFileName);
			System.out.println("update CRL success");
		} catch (CRLException | IOException | OperatorCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String checkMsgType(byte[] getData) {
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		String type = pkiMsg.getType();
		return type;
	}

	public String prepareToIssueCert(byte[] getData) {
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ReqToIssueCertFormat reqToIssueCert = pbMsg.getReqToIssueCert(pkiMsg);
		byte[] subjectCsrFile = reqToIssueCert.getSubjectCsrFile().toByteArray();
		try {
			subjectCsr = new PKCS10CertificationRequest(subjectCsrFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String subjcetCertName = reqToIssueCert.getSubjectCertName();
		return subjcetCertName;
	}

	public List<String> saveCertFromMsg(byte[] getData) {
		List<String> saveCertList = new ArrayList<>();
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ResWithCertFormat resWithCert = pbMsg.getResWithCert(pkiMsg);
		for(int i = 0; i < resWithCert.getCertInfoCount(); i++) {
			byte[] certBytes = resWithCert.getCertInfo(i).getCertFile().toByteArray();
			String certFileName = resWithCert.getCertInfo(i).getCertFileName();
			InputStream inStream = new ByteArrayInputStream(certBytes);
			CertificateFactory cf;
			try {
				cf = CertificateFactory.getInstance("X.509");
				X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
				writePemFile(cert, certFileName);
				saveCertList.add(certFileName);
			} catch (CertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return saveCertList;
	}
	
	public byte[] makeReqToIssueCrossCertMsg(String subjectCsrName, String subjectCertName) {
		PKCS10CertificationRequest csr = readCsrFromFile(subjectCsrName);
		try {
			byte[] payload = pbMsg.setReqToIssueCrossCert(csr.getEncoded(), subjectCertName);
			byte[] pkiMsgBytes = pbMsg.setPkiMsg("ReqToIssueCrossCertFormat", payload);
			return pkiMsgBytes;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
