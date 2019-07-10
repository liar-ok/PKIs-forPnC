package kr.ac.hmcl.mju.Cps_2_RA;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
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
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import javax.xml.bind.JAXBElement;

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

import exiCodec.ExiCodec;
import kr.ac.hmcl.mju.Cps_2_RA.ContractData.ContractDataFormat;
import kr.ac.hmcl.mju.Cps_2_RA.PkiMsg.PkiMsgFormat;
import kr.ac.hmcl.mju.Cps_2_RA.ReqToCertInstRes.ReqToCertInstResFormat;
import kr.ac.hmcl.mju.Cps_2_RA.ReqToIssueCert.ReqToIssueCertFormat;
import kr.ac.hmcl.mju.Cps_2_RA.ResWithCert.CertInfo;
import kr.ac.hmcl.mju.Cps_2_RA.ResWithCert.ResWithCertFormat;
import msgDef.CanonicalizationMethodType;
import msgDef.CertificateChainType;
import msgDef.CertificateInstallationResType;
import msgDef.ContractSignatureEncryptedPrivateKeyType;
import msgDef.DiffieHellmanPublickeyType;
import msgDef.DigestMethodType;
import msgDef.EMAIDType;
import msgDef.ReferenceType;
import msgDef.ResponseCodeType;
import msgDef.SignatureMethodType;
import msgDef.SignedInfoType;
import msgDef.SubCertificatesType;
import msgDef.TransformType;
import msgDef.TransformsType;
import msgDef.V2GMessage;
import risev2gClass.ByteUtils;
import risev2gClass.GlobalValues;
import risev2gClass.MessageHandler;
import risev2gClass.SendMessage;
import risev2gClass.V2GMessages;
import risev2gClass.V2GTPMessage;

public class SecUtils {
	PBMessage pbMsg = new PBMessage();
	PKCS10CertificationRequest subjectCsr = null;
	int rootCertSerial = 0;
	int sub1CertSerial = 10;
	int sub2CertSerial = 20;
	int contractCertSerial = 30;

	// ===================for making ISO 15118 MSG==============================
	static ExiCodec exiCodec;

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

	public void generateRootCertificate(String csrFileName, String issuerDn, String privateKeyFileName,
			String publicKeyFileName, String certName, int validity) {

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

	public void generateSubCa1Certificate(String issuerDn, String privateKeyFileName, String publicKeyFileName,
			String certName, int validity) {

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

	private boolean verifyCertificate(X509Certificate certificate, X509Certificate issuingCertificate) {
		// check signature
		if (!verifySignature(certificate, issuingCertificate)) {
			return false;
		}
		// check validity period
		if (!verifyValidityPeriod(certificate)) {
			return false;
		}

		return true;
	}

	public boolean verifyCertificate(String certName, String issuingCertName) {

		X509Certificate certificate = readCertificateFromFile(certName);
		X509Certificate issuingCertificate = readCertificateFromFile(issuingCertName);
		boolean result = verifyCertificate(certificate, issuingCertificate);
		return result;
	}

	private boolean verifySubCA1Certificate(X509Certificate certificate, X509Certificate issuingCertificate) {
		// check if Certificate is valid
		boolean result = verifyCertificate(certificate, issuingCertificate);
		if (!result) {
			return false;
		}
		// check if Certificate attributes is correct
		// Check pathLenContraint (maximum number of non-self-issued intermediate
		// certificates that may follow this certificate)
		if (certificate.getBasicConstraints() != 1) {
			System.out.println("Sub-CA 1 certificate with distinguished name '"
					+ certificate.getSubjectX500Principal().getName() + "' has incorrect value for "
					+ "pathLenConstraint. Should be 1 instead of " + certificate.getBasicConstraints());
			return false;
		}
		System.out.println("SubCA1 Certificate is valid");

		return true;
	}

	public boolean verifySubCA1Certificate(String certName, String issuingCertName) {

		X509Certificate certificate = readCertificateFromFile(certName);
		X509Certificate issuingCertificate = readCertificateFromFile(issuingCertName);
		boolean result = verifySubCA1Certificate(certificate, issuingCertificate);
		return result;
	}

	private boolean verifySubCA2Certificate(X509Certificate certificate, X509Certificate issuingCertificate) {
		// check if Certificate is valid
		boolean result = verifyCertificate(certificate, issuingCertificate);
		if (!result) {
			return false;
		}
		// check if Certificate attributes is correct
		// Check pathLenContraint (maximum number of non-self-issued intermediate
		// certificates that may follow this certificate)
		if (certificate.getBasicConstraints() != 0) {
			System.out.println("Sub-CA 2 certificate with distinguished name '"
					+ certificate.getSubjectX500Principal().getName() + "' has incorrect value for "
					+ "pathLenConstraint. Should be 0 instead of " + certificate.getBasicConstraints());
			return false;
		}
		System.out.println("SubCA2 Certificate is valid");

		return true;
	}

	public boolean verifySubCA2Certificate(String certName, String issuingCertName) {

		X509Certificate certificate = readCertificateFromFile(certName);
		X509Certificate issuingCertificate = readCertificateFromFile(issuingCertName);
		boolean result = verifySubCA2Certificate(certificate, issuingCertificate);
		return result;

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
	
	public byte[] makeReqToGetOEMProvCertMsg(String pcid) {
		byte[] payload = pbMsg.setReqToGetOEMProvCert(pcid);
		byte[] pkiMsgBytes =pbMsg.setPkiMsg("ReqToGetOEMProvCert", payload);
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
	public byte[] makeReqToGetOEMRootCertMsg() {
		byte[] payload = new byte[0];
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("ReqToGetOEMRootCert", payload);
		return pkiMsgBytes;
	}
	
	public byte[] makeReqToGetV2GCrossRootCertMsg() {
		byte[] payload = new byte[0];
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("ReqToGetV2GCrossRootCert", payload);
		return pkiMsgBytes;
	}

	public byte[] makeSuccessToGetContractDataMsg() {
		byte[] payload = new byte[0];
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("SuccessToGetContractData", payload);
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
		for (int i = 0; i < resWithCert.getCertInfoCount(); i++) {
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

	/**
	 * Encrypts the private key of the contract certificate which is to be sent to
	 * the EVCC. First, the shared secret based on the ECDH parameters is
	 * calculated, then the symmetric session key with which the private key of the
	 * contract certificate is to be encrypted.
	 * 
	 * @param publicKey
	 *            The public key of either the OEM provisioning certificate (in case
	 *            of CertificateInstallation) or the to be updated contract
	 *            certificate (in case of CertificateUpdate)
	 * @param dhPrivateKeyFileName
	 *            The private key file name of DHkeyPair
	 * @param contractCertPrivateKeyFileName
	 *            The private key file name of the contract certificate
	 * @return The encrypted private key of the to be installed contract certificate
	 */
	public byte[] encryptContractCertPrivateKey(ECPublicKey publicKey, String dhPrivateKeyFileName,
			String contractCertPrivateKeyFileName) {
		// Generate the shared secret by using the public key of either OEMProvCert or
		// ContractCert
		PrivateKey privateKey = readPrivateKeyFromFile(dhPrivateKeyFileName);

		byte[] sharedSecret = generateSharedSecret((ECPrivateKey) privateKey, publicKey);

		if (sharedSecret == null) {
			System.out.println("Shared secret could not be generated");
			return null;
		}

		// The session key is generated using the computed shared secret
		SecretKey sessionKey = generateSessionKey(sharedSecret);

		// Finally, the private key of the contract certificate is encrypted using the
		// session key
		PrivateKey contractCertPrivateKey = readPrivateKeyFromFile(contractCertPrivateKeyFileName);
		byte[] encryptedContractCertPrivateKey = encryptPrivateKey(sessionKey, (ECPrivateKey) contractCertPrivateKey);

		return encryptedContractCertPrivateKey;
	}

	/**
	 * The shared secret is computed using the domain parameters of the named curve
	 * "secp256r1", the private key part of the ephemeral key pair, and the OEM
	 * provisioning certiicate��s public key (in case of certificate installation)
	 * or the contract certificate's public key (in case of certificate update). The
	 * shared secret is used as input to a key derivation function. A key derivation
	 * function (KDF) is a deterministic algorithm to derive a key of a given size
	 * from some secret value. If two parties use the same shared secret value and
	 * the same KDF, they should always derive exactly the same key.
	 * 
	 * @param privateKey
	 *            The private key of an EC key pair generated from the named curve
	 *            "secp256r1".
	 * 
	 *            The mobility operator (MO) provides his ephemeral private key when
	 *            using this function for generating the shared secret to encrypt
	 *            the private key of the contract certificate.
	 * 
	 *            The EVCC provides the private key belonging to his OEM
	 *            provisioning certificate's public key when using this function for
	 *            generating the shared secret to decrypt the encrypted private key
	 *            of the newly to be installed contract certificate.
	 * @param publicKey
	 *            The public key of an EC key pair generated from the named curve
	 *            "secp256r1"
	 * 
	 *            The mobility operator (MO) provides the static OEM provisioning
	 *            certificate's (in case of CertificateInstallation) or old contract
	 *            certificate's (in case of CertificateUpdate) public key when using
	 *            this function for generating the shared secret to encrypt the
	 *            private key of the contract certificate.
	 * 
	 *            The EVCC provides the ephemeral public key of the MO (coming with
	 *            the CertificateInstallationRes or CertificateUpdateRes,
	 *            respectively) when using this function for generating the shared
	 *            secret to decrypt the encrypted private key of the newly to be
	 *            installed contract certificate.
	 * @return The computed shared secret of the elliptic curve Diffie-Hellman key
	 *         exchange protocol
	 */
	public static byte[] generateSharedSecret(ECPrivateKey privateKey, ECPublicKey publicKey) {
		try {
			KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
			keyAgreement.init(privateKey, new SecureRandom());
			keyAgreement.doPhase(publicKey, true);

			return keyAgreement.generateSecret();
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println(
					e.getClass().getSimpleName() + " occurred while trying to generate the shared secret (ECDH)");
			return null;
		}
	}

	/**
	 * The key derivation function (KDF). See [V2G2-818] in ISO/IEC 15118-2 for
	 * further information.
	 * 
	 * @param sharedSecret
	 *            The shared secret derived from the ECDH algorithm
	 */
	public static SecretKey generateSessionKey(byte[] sharedSecret) {
		MessageDigest md = null;
		/*
		 * TODO it is unclear to me what should be the content of suppPubInfo or
		 * suppPrivInfo according to page 49 of
		 * http://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-56Ar2.pdf
		 * Requirement [V2G2-818] is not clear about that.
		 */
		byte[] suppPubInfo = null;
		byte[] suppPrivInfo = null;

		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			System.out.println("Message digest algorithm SHA-256 not supported");
			return null;
		}

		ByteArrayOutputStream baosOtherInfo = new ByteArrayOutputStream();
		try {
			baosOtherInfo.write(ByteUtils.toByteArrayFromHexString("01")); // algorithm ID
			baosOtherInfo.write(ByteUtils.toByteArrayFromHexString("55")); // partyUInfo
			baosOtherInfo.write(ByteUtils.toByteArrayFromHexString("56")); // partyVInfo
			if (suppPubInfo != null)
				baosOtherInfo.write(suppPubInfo);
			if (suppPrivInfo != null)
				baosOtherInfo.write(suppPrivInfo);
		} catch (IOException e) {
			System.out.println("IOException occurred while trying to write OtherInfo for session key generation");
		}

		byte[] otherInfo = baosOtherInfo.toByteArray();

		// A symmetric encryption key of exactly 128 bits shall be derived.
		byte[] sessionKeyAsByteArray = concatKDF(md, sharedSecret, 128, otherInfo);

		SecretKey sessionKey = null;
		try {
			sessionKey = new SecretKeySpec(sessionKeyAsByteArray, "AES");
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException occurred while trying to generate session key");
		}

		return sessionKey;
	}

	private static byte[] concatKDF(MessageDigest md, byte[] z, int keyDataLen, byte[] otherInfo) {
		final long MAX_HASH_INPUTLEN = Long.MAX_VALUE;
		final long UNSIGNED_INT_MAX_VALUE = 4294967295L;
		keyDataLen = keyDataLen / 8;
		byte[] key = new byte[keyDataLen];

		int hashLen = md.getDigestLength();
		int reps = keyDataLen / hashLen;

		if (reps > UNSIGNED_INT_MAX_VALUE) {
			System.out.println("Key derivation failed");
			return null;
		}

		int counter = 1;
		byte[] counterInBytes = ByteUtils.intToFourBytes(counter);

		if ((counterInBytes.length + z.length + otherInfo.length) * 8 > MAX_HASH_INPUTLEN) {
			System.out.println("Key derivation failed");
			return null;
		}

		for (int i = 0; i <= reps; i++) {
			md.reset();
			md.update(ByteUtils.intToFourBytes(i + 1));
			md.update(z);
			md.update(otherInfo);

			byte[] hash = md.digest();
			if (i < reps) {
				System.arraycopy(hash, 0, key, hashLen * i, hashLen);
			} else {
				if (keyDataLen % hashLen == 0) {
					System.arraycopy(hash, 0, key, hashLen * i, hashLen);
				} else {
					System.arraycopy(hash, 0, key, hashLen * i, keyDataLen % hashLen);
				}
			}
		}

		return key;
	}

	private static byte[] encryptPrivateKey(SecretKey sessionKey, ECPrivateKey contractCertPrivateKey) {
		try {
			/*
			 * Padding of the plain text (private key) is not required as its length (256
			 * bit) is a multiple of the block size (128 bit) of the used encryption
			 * algorithm (AES)
			 */
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			IvParameterSpec ivParamSpec = new IvParameterSpec(generateRandomNumber(16));
			cipher.init(Cipher.ENCRYPT_MODE, sessionKey, ivParamSpec);

			/*
			 * Not the complete ECPrivateKey container, but the private value s represents
			 * the 256 bit private key which must be encoded. The private key is stored as
			 * an ASN.1 integer which may need to have zero padding in the most significant
			 * bits removed (if 33 bytes)
			 */
			byte[] encryptedKey;
			if (contractCertPrivateKey.getS().toByteArray().length == 33) {
				byte[] temp = new byte[32];
				System.arraycopy(contractCertPrivateKey.getS().toByteArray(), 1, temp, 0,
						contractCertPrivateKey.getS().toByteArray().length - 1);
				encryptedKey = cipher.doFinal(temp);
			} else {
				encryptedKey = cipher.doFinal(contractCertPrivateKey.getS().toByteArray());
			}

			/*
			 * The IV must be transmitted in the 16 most significant bytes of the
			 * ContractSignatureEncryptedPrivateKey
			 */
			byte[] encryptedKeyWithIV = new byte[ivParamSpec.getIV().length + encryptedKey.length];
			System.arraycopy(ivParamSpec.getIV(), 0, encryptedKeyWithIV, 0, ivParamSpec.getIV().length);
			System.arraycopy(encryptedKey, 0, encryptedKeyWithIV, ivParamSpec.getIV().length, encryptedKey.length);

			return encryptedKeyWithIV;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getSimpleName() + " occurred while trying to encrypt private key."
					+ "\nSession key (" + sessionKey.getEncoded().length + " bytes): "
					+ ByteUtils.toHexString(sessionKey.getEncoded()) + "\nContract certificate private key ("
					+ contractCertPrivateKey.getS().toByteArray().length + " bytes): "
					+ ByteUtils.toHexString(contractCertPrivateKey.getS().toByteArray()));
		}

		return null;
	}

	/**
	 * Returns a random number of a given length of bytes.
	 * 
	 * @param lengthOfBytes
	 *            The number of bytes which hold the generated random number
	 * @return A random number given as a byte array
	 */
	public static byte[] generateRandomNumber(int lengthOfBytes) {
		// TODO how to assure that the entropy of the genChallenge is at least 120 bits
		// according to [V2G2-826]?

		SecureRandom random = new SecureRandom();
		byte[] randomNumber = new byte[lengthOfBytes];
		random.nextBytes(randomNumber);

		return randomNumber;
	}

	// ===================================for CPS
	// =================================================

	public boolean checkContractData(byte[] getData, String moRootCertName) {
		// receive contract data and prepare to process
		// ContractData = [eMAID, DHPublicKey, ContractEncryptedPrivateKey,
		// ContractCertChain, PCID]
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ContractDataFormat cd = pbMsg.getContractData(pkiMsg);

		List<X509Certificate> moCertChain = new ArrayList();
		for (int i = 0; i < 3; i++) { // chain length is 3
			byte[] certBytes = cd.getContractCertChain(i).toByteArray();
			CertificateFactory certFactory;
			try {
				certFactory = CertificateFactory.getInstance("x.509");
				InputStream in = new ByteArrayInputStream(certBytes);
				X509Certificate cert = (X509Certificate) certFactory.generateCertificate(in);
				moCertChain.add(cert);
			} catch (CertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		// check MO ContractCertificate chain validation
		// check Contract Certificate

		if (!verifyCertificate(moCertChain.get(0), moCertChain.get(1))) {
			return false;
		}
		// check mo subca2 certificate
		if (!verifySubCA2Certificate(moCertChain.get(1), moCertChain.get(2))) {
			return false;
		}
		// check mo subca 1 certificate
		X509Certificate moRootCert = readCertificateFromFile(moRootCertName);
		if (!verifySubCA1Certificate(moCertChain.get(2), moRootCert)) {
			return false;
		}
		return true;
	}

	public byte[] makeCertificateInstallationResMsg(byte[] getData, CertData certData) {
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ContractDataFormat cd = pbMsg.getContractData(pkiMsg);
		CertificateInstallationResType certificateInstallationRes = new CertificateInstallationResType();
		// set response Code
		certificateInstallationRes.setResponseCode(ResponseCodeType.OK);
		System.out.println("set response Code");
		// set saContractCertificateChain
		CertificateChainType saContractCertificateChain = new CertificateChainType();
		try {
			saContractCertificateChain.setCertificate(readCertificateFromFile(certData.getCertName()).getEncoded());
			List<byte[]> subCertList = new ArrayList();
			subCertList.add(readCertificateFromFile(certData.getSubCa1CertName()).getEncoded());
			subCertList.add(readCertificateFromFile(certData.getSubCa2CertName()).getEncoded());
			SubCertificatesType subCertificates = new SubCertificatesType();
			subCertificates.setCertificate(subCertList);
			saContractCertificateChain.setSubCertificates(subCertificates);
			certificateInstallationRes.setSAProvisioningCertificateChain(saContractCertificateChain);
			System.out.println("set saContractCertificateChain");
		} catch (CertificateEncodingException e) {
			System.out.println("fail to set SAProvisisoningCertificateChain");
			e.printStackTrace();
		}
		// set contractSignatureCertChain
		CertificateChainType contractSignatureCertChain = new CertificateChainType();
		contractSignatureCertChain.setCertificate(cd.getContractCertChain(0).toByteArray());
		List<byte[]> moSubCertChain = new ArrayList();
		for (int i = 1; i < 3; i++) { // chain length is 3
			byte[] certBytes = cd.getContractCertChain(i).toByteArray();
			CertificateFactory certFactory;
			try {
				certFactory = CertificateFactory.getInstance("x.509");
				InputStream in = new ByteArrayInputStream(certBytes);
				X509Certificate cert = (X509Certificate) certFactory.generateCertificate(in);
				moSubCertChain.add(cert.getEncoded());
			} catch (CertificateException e) {
				System.out.println("fail to get mo Contract Cert chain");
				e.printStackTrace();
			}
		}
		SubCertificatesType subCertificates = new SubCertificatesType();
		subCertificates.setCertificate(moSubCertChain);
		contractSignatureCertChain.setSubCertificates(subCertificates);
		certificateInstallationRes.setContractSignatureCertChain(contractSignatureCertChain);
		certificateInstallationRes.getContractSignatureCertChain().setId("id1");
		System.out.println("set contractSignatureCertChain");
		// set contractSignatureEncryptedPrivateKey
		ContractSignatureEncryptedPrivateKeyType encryptedPrivateKey = new ContractSignatureEncryptedPrivateKeyType();
		encryptedPrivateKey.setValue(cd.getContractEncryptedPrivateKey().toByteArray());
		encryptedPrivateKey.setId("id2");
		certificateInstallationRes.setContractSignatureEncryptedPrivateKey(encryptedPrivateKey);
		System.out.println("set contractSignautreEncrypted Privatekey");
		// set DHpublic key
		DiffieHellmanPublickeyType dhPublicKey = new DiffieHellmanPublickeyType();
		dhPublicKey.setValue(cd.getDHPublicKey().toByteArray());
		dhPublicKey.setId("id3");
		certificateInstallationRes.setDHpublickey(dhPublicKey);
		System.out.println("set DH public key");
		// set EMAID
		EMAIDType emaid = new EMAIDType();
		emaid.setValue(cd.getEmaid());
		emaid.setId("id4");
		certificateInstallationRes.setEMAID(emaid);
		System.out.println("set EMAID");
		// set xml reference elements

		HashMap<String, byte[]> xmlSignatureRefElements = new HashMap<String, byte[]>();

		MessageHandler messageHandler = MessageHandler.getInstance();

		xmlSignatureRefElements.put(certificateInstallationRes.getContractSignatureCertChain().getId(),
				generateDigest(certificateInstallationRes.getContractSignatureCertChain().getId(),
						messageHandler.getJaxbElement(certificateInstallationRes.getContractSignatureCertChain())));
		xmlSignatureRefElements.put(certificateInstallationRes.getContractSignatureEncryptedPrivateKey().getId(),
				generateDigest(certificateInstallationRes.getContractSignatureEncryptedPrivateKey().getId(),
						messageHandler
								.getJaxbElement(certificateInstallationRes.getContractSignatureEncryptedPrivateKey())));
		xmlSignatureRefElements.put(certificateInstallationRes.getDHpublickey().getId(),
				generateDigest(certificateInstallationRes.getDHpublickey().getId(),
						messageHandler.getJaxbElement(certificateInstallationRes.getDHpublickey())));
		xmlSignatureRefElements.put(certificateInstallationRes.getEMAID().getId(),
				generateDigest(certificateInstallationRes.getEMAID().getId(),
						messageHandler.getJaxbElement(certificateInstallationRes.getEMAID())));
		System.out.println("set xml signatureRef");
		// set signing private key
		ECPrivateKey signaturePrivateKey = (ECPrivateKey) readPrivateKeyFromFile(certData.getPrivateFileName());
		System.out.println("contract private Key:" + signaturePrivateKey.toString());
		// set Message
		byte[] sessionID = new byte[8];
		V2GMessage v2gMessage = messageHandler.getV2GMessage(sessionID, xmlSignatureRefElements, signaturePrivateKey,
				messageHandler.getJaxbElement(certificateInstallationRes));

		SendMessage sendMsg = new SendMessage(v2gMessage, 60000);
		byte[] payload = null;
		payload = (byte[]) messageHandler.v2gMsgToExi(sendMsg.getPayload());

		return payload;
	}

	public static byte[] generateDigest(String id, JAXBElement jaxbMessageOrField) {
		byte[] encoded;

		// The schema-informed fragment grammar option needs to be used for EXI
		// encodings in the header's signature
		getExiCodec().setFragment(true);

		/*
		 * When creating the signature value for the SignedInfoElement, we need to use
		 * the XMLdsig schema, whereas for creating the reference elements of the
		 * signature, we need to use the V2G_CI_MsgDef schema.
		 */
		if (jaxbMessageOrField.getValue() instanceof SignedInfoType) {
			encoded = getExiCodec().encodeEXI(jaxbMessageOrField, GlobalValues.SCHEMA_PATH_XMLDSIG.toString());
		} else
			encoded = getExiCodec().encodeEXI(jaxbMessageOrField, GlobalValues.SCHEMA_PATH_MSG_DEF.toString());

		// Do not use the schema-informed fragment grammar option for other EXI
		// encodings (message bodies)
		getExiCodec().setFragment(false);

		if (encoded == null) {
			System.out.println("Digest could not be generated because of EXI encoding problem");
			return null;
		}

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(encoded);
			byte[] digest = md.digest();

			/*
			 * if (showSignatureVerificationLog) {
			 * 
			 * Show Base64 encoding of digests only for reference elements, not for the
			 * SignedInfo element. The hashed SignedInfo element is input for ECDSA before
			 * the final signature value gets Base64 encoded.
			 * 
			 * if ( !(jaxbMessageOrField.getValue() instanceof SignedInfoType) ) {
			 * getLogger().debug("\n" + "\tDigest generated for XML reference element " +
			 * jaxbMessageOrField.getName().getLocalPart() + " with ID '" + id + "': " +
			 * ByteUtils.toHexString(digest) + "\n" + "\tBase64 encoding of digest: " +
			 * Base64.getEncoder().encodeToString(digest)); } }
			 */

			return digest;
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException occurred while trying to create digest");
			e.printStackTrace();
			return null;
		}
	}

	private static ExiCodec getExiCodec() {
		return exiCodec;
	}

	public static void setExiCodec(ExiCodec exiCodecChoice) {
		exiCodec = exiCodecChoice;
	}

	/**
	 * Returns the SignedInfo element of the V2GMessage header, based on the
	 * provided HashMap which holds the reference IDs (URIs) and the corresponding
	 * SHA-256 digests.
	 * 
	 * @param xmlSignatureRefElements
	 *            A HashMap of Strings (reflecting the reference IDs) and digest
	 *            values
	 * @return The SignedInfoType instance
	 */
	public static SignedInfoType getSignedInfo(HashMap<String, byte[]> xmlSignatureRefElements) {
		/*
		 * According to requirement [V2G2-771] in ISO/IEC 15118-2 the following message
		 * elements of the XML signature framework shall not be used: - Id (attribute in
		 * SignedInfo) - ##any in SignedInfo – CanonicalizationMethod - HMACOutputLength
		 * in SignedInfo – SignatureMethod - ##other in SignedInfo – SignatureMethod -
		 * Type (attribute in SignedInfo-Reference) - ##other in SignedInfo – Reference
		 * – Transforms – Transform - XPath in SignedInfo – Reference – Transforms –
		 * Transform - ##other in SignedInfo – Reference – DigestMethod - Id (attribute
		 * in SignatureValue) - Object (in Signature) - KeyInfo
		 */
		DigestMethodType digestMethod = new DigestMethodType();
		digestMethod.setAlgorithm("http://www.w3.org/2001/04/xmlenc#sha256");

		TransformType transform = new TransformType();
		transform.setAlgorithm("http://www.w3.org/TR/canonical-exi/");
		TransformsType transforms = new TransformsType();
		transforms.getTransform().add(transform);

		List<ReferenceType> references = new ArrayList<ReferenceType>();
		xmlSignatureRefElements.forEach((k, v) -> {
			ReferenceType reference = new ReferenceType();
			reference.setDigestMethod(digestMethod);
			reference.setDigestValue(v);
			reference.setTransforms(transforms);
			reference.setURI("#" + k);

			references.add(reference);
		});

		CanonicalizationMethodType canonicalizationMethod = new CanonicalizationMethodType();
		canonicalizationMethod.setAlgorithm("http://www.w3.org/TR/canonical-exi/");

		SignatureMethodType signatureMethod = new SignatureMethodType();
		signatureMethod.setAlgorithm("http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256");

		SignedInfoType signedInfo = new SignedInfoType();
		signedInfo.setCanonicalizationMethod(canonicalizationMethod);
		signedInfo.setSignatureMethod(signatureMethod);
		signedInfo.getReference().addAll(references);

		return signedInfo;
	}

	/**
	 * Signs the SignedInfo element of the V2GMessage header.
	 * 
	 * @param signedInfoElementExi
	 *            The EXI-encoded SignedInfo element given as a byte array
	 * @param ecPrivateKey
	 *            The private key which is used to sign the SignedInfo element
	 * @return The signature value for the SignedInfo element given as a byte array
	 */
	public static byte[] signSignedInfoElement(byte[] signedInfoElementExi, ECPrivateKey ecPrivateKey) {
		try {
			Signature ecdsa = Signature.getInstance("SHA256withECDSA", "BC");

			System.out.println("EXI encoded SignedInfo: " + ByteUtils.toHexString(signedInfoElementExi));

			if (ecPrivateKey != null) {
				System.out.println("\n\tPrivate key used for creating signature: "
						+ ByteUtils.toHexString(ecPrivateKey.getS().toByteArray()));

				ecdsa.initSign(ecPrivateKey);
				ecdsa.update(signedInfoElementExi);

				byte[] signature = ecdsa.sign();

				// Java operates on DER encoded signatures, but we must send the raw r and s
				// values as signature
				byte[] rawSignature = getRawSignatureFromDEREncoding(signature);

				System.out.println("Signature value: " + ByteUtils.toHexString(rawSignature));

				return rawSignature;
			} else {
				System.out.println("Private key used to sign SignedInfo element is null");
				return null;
			}
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | NoSuchProviderException e) {
			System.out.println(e.getClass().getSimpleName() + " occurred while trying to create signature");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * An ECDSA signature consists of two positive integers r and s, each of the bit
	 * length equal to the curve size. When Java is creating an ECDSA signature, it
	 * is encoding it in the DER (Distinguished Encoding Rules) format. But in ISO
	 * 15118, we do not expect DER encoded signatures. Thus, this function takes the
	 * DER encoded signature as input and returns the raw r and s integer values of
	 * the signature. See further explanations in the @getDEREncodedSignature
	 * function for DER encoded ECDSA signatures.
	 * 
	 * @param derEncodedSignature
	 *            The DER encoded signature as a result from
	 *            java.security.Signature.sign()
	 * @return A byte array containing only the r and s value of the signature
	 */
	public static byte[] getRawSignatureFromDEREncoding(byte[] derEncodedSignature) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] r = new byte[32];
		byte[] s = new byte[32];

		// Length of r is encoded in the fourth byte
		int lengthOfR = derEncodedSignature[3];

		// Length of r is encoded in the second byte AFTER r
		int lengthOfS = derEncodedSignature[lengthOfR + 5];

		// Length of r and s are either 33 bytes (including padding byte 0x00), 32 bytes
		// (normal), or less (leftmost 0x00 bytes were removed)
		try {
			if (lengthOfR == 33)
				System.arraycopy(derEncodedSignature, 5, r, 0, lengthOfR - 1); // skip leftmost padding byte 0x00
			else if (lengthOfR == 32)
				System.arraycopy(derEncodedSignature, 4, r, 0, lengthOfR);
			else
				System.arraycopy(derEncodedSignature, 4, r, 32 - lengthOfR, lengthOfR); // destPos = number of leftmost
																						// 0x00 bytes

			if (lengthOfS == 33)
				System.arraycopy(derEncodedSignature, lengthOfR + 7, s, 0, lengthOfS - 1); // skip leftmost padding byte
																							// 0x00
			else if (lengthOfS == 32)
				System.arraycopy(derEncodedSignature, lengthOfR + 6, s, 0, lengthOfS);
			else
				System.arraycopy(derEncodedSignature, lengthOfR + 6, s, 32 - lengthOfS, lengthOfS); // destPos = number
																									// of leftmost 0x00
																									// bytes
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(
					"ArrayIndexOutOfBoundsException occurred while trying to get raw signature from DER encoded signature.");
			e.printStackTrace();
		}

		try {
			baos.write(r);
			baos.write(s);
		} catch (IOException e) {
			System.out.println("IOException occurred while trying to write r and s into DER-encoded signature");
			e.printStackTrace();
		}

		byte[] rawRAndS = baos.toByteArray();

		/*
		 * if (showSignatureVerificationLog) { StringBuilder sb = new StringBuilder();
		 * sb.append("Signature encoding DER -> raw:").append(System.lineSeparator());
		 * sb.append("\tDER: ").append(ByteUtils.toHexString(derEncodedSignature)).
		 * append(System.lineSeparator());
		 * sb.append("\tR: ").append(ByteUtils.toHexString(r)).append(System.
		 * lineSeparator());
		 * sb.append("\tS: ").append(ByteUtils.toHexString(s)).append(System.
		 * lineSeparator());
		 * sb.append("\tRaw: ").append(ByteUtils.toHexString(rawRAndS));
		 * getLogger().debug(sb.toString()); }
		 */

		return rawRAndS;
	}

	public String getPcidFromContractData(byte[] getData) {
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ContractDataFormat cd = pbMsg.getContractData(pkiMsg);
		return cd.getPcid();
	}

	public String getPcidFromReqToCertInstRes(byte[] getData) {
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ReqToCertInstResFormat reqToCertInstRes = pbMsg.getReqToCertInstRes(pkiMsg);
		byte[] certBytes = reqToCertInstRes.getOemProvisioningCert().toByteArray();
		InputStream inStream = new ByteArrayInputStream(certBytes);
		CertificateFactory cf;
		String dn = null;
		try {
			cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
			 dn = cert.getSubjectX500Principal().getName();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pcid = dn.substring(10, 27);
		return pcid;
	}

	public byte[] makeResToCertInstRes(byte[] v2gMessageBytes) {
		byte[] payload = pbMsg.setResToCertInstRes(v2gMessageBytes);
		byte[] pkiMsgBytes = pbMsg.setPkiMsg("ResToCertInstRes", payload);
		return pkiMsgBytes;
	}

	public boolean CheckOemProvCertChainValidity(ProvCertData provCertData, String oemRootCertName) {
		List<X509Certificate> oemCertChain = new ArrayList<X509Certificate>();
		oemCertChain.add(readCertificateFromFile(provCertData.getCertName()));
		oemCertChain.add(readCertificateFromFile(provCertData.getSubCa2CertName()));
		oemCertChain.add(readCertificateFromFile(provCertData.getSubCa1CertName()));
		oemCertChain.add(readCertificateFromFile(provCertData.getRootCertName()));
		
		if (!verifyCertificate(oemCertChain.get(0), oemCertChain.get(1))) {
			return false;
		}
		if (!verifySubCA2Certificate(oemCertChain.get(1), oemCertChain.get(2))) {
			return false;
		}
		if (!verifySubCA1Certificate(oemCertChain.get(2), oemCertChain.get(3))) {
			return false;
		}
		return true;
	}
	
	public byte[] makeCrossCertificateInstallationResMsg(byte[] getData, CertData certData, String crossRootCertName) {
		PkiMsgFormat pkiMsg = pbMsg.getPkiMsg(getData);
		ContractDataFormat cd = pbMsg.getContractData(pkiMsg);
		CertificateInstallationResType certificateInstallationRes = new CertificateInstallationResType();
		// set response Code
		certificateInstallationRes.setResponseCode(ResponseCodeType.OK);
		System.out.println("set response Code");
		// set saContractCertificateChain 
		// include in cross Root Cert
		CertificateChainType saContractCertificateChain = new CertificateChainType();
		try {
			saContractCertificateChain.setCertificate(readCertificateFromFile(certData.getCertName()).getEncoded());
			List<byte[]> subCertList = new ArrayList();			
			subCertList.add(readCertificateFromFile(certData.getSubCa1CertName()).getEncoded());
			subCertList.add(readCertificateFromFile(certData.getSubCa2CertName()).getEncoded());
			subCertList.add(readCertificateFromFile(crossRootCertName).getEncoded());
			SubCertificatesType subCertificates = new SubCertificatesType();
			subCertificates.setCertificate(subCertList);
			saContractCertificateChain.setSubCertificates(subCertificates);
			certificateInstallationRes.setSAProvisioningCertificateChain(saContractCertificateChain);
			System.out.println("set saContractCertificateChain");
		} catch (CertificateEncodingException e) {
			System.out.println("fail to set SAProvisisoningCertificateChain");
			e.printStackTrace();
		}
		// set contractSignatureCertChain
		CertificateChainType contractSignatureCertChain = new CertificateChainType();
		contractSignatureCertChain.setCertificate(cd.getContractCertChain(0).toByteArray());
		List<byte[]> moSubCertChain = new ArrayList();
		for (int i = 1; i < 3; i++) { // chain length is 3
			byte[] certBytes = cd.getContractCertChain(i).toByteArray();
			CertificateFactory certFactory;
			try {
				certFactory = CertificateFactory.getInstance("x.509");
				InputStream in = new ByteArrayInputStream(certBytes);
				X509Certificate cert = (X509Certificate) certFactory.generateCertificate(in);
				moSubCertChain.add(cert.getEncoded());
			} catch (CertificateException e) {
				System.out.println("fail to get mo Contract Cert chain");
				e.printStackTrace();
			}
		}
		SubCertificatesType subCertificates = new SubCertificatesType();
		subCertificates.setCertificate(moSubCertChain);
		contractSignatureCertChain.setSubCertificates(subCertificates);
		certificateInstallationRes.setContractSignatureCertChain(contractSignatureCertChain);
		certificateInstallationRes.getContractSignatureCertChain().setId("id1");
		System.out.println("set contractSignatureCertChain");
		// set contractSignatureEncryptedPrivateKey
		ContractSignatureEncryptedPrivateKeyType encryptedPrivateKey = new ContractSignatureEncryptedPrivateKeyType();
		encryptedPrivateKey.setValue(cd.getContractEncryptedPrivateKey().toByteArray());
		encryptedPrivateKey.setId("id2");
		certificateInstallationRes.setContractSignatureEncryptedPrivateKey(encryptedPrivateKey);
		System.out.println("set contractSignautreEncrypted Privatekey");
		// set DHpublic key
		DiffieHellmanPublickeyType dhPublicKey = new DiffieHellmanPublickeyType();
		dhPublicKey.setValue(cd.getDHPublicKey().toByteArray());
		dhPublicKey.setId("id3");
		certificateInstallationRes.setDHpublickey(dhPublicKey);
		System.out.println("set DH public key");
		// set EMAID
		EMAIDType emaid = new EMAIDType();
		emaid.setValue(cd.getEmaid());
		emaid.setId("id4");
		certificateInstallationRes.setEMAID(emaid);
		System.out.println("set EMAID");
		// set xml reference elements

		HashMap<String, byte[]> xmlSignatureRefElements = new HashMap<String, byte[]>();

		MessageHandler messageHandler = MessageHandler.getInstance();

		xmlSignatureRefElements.put(certificateInstallationRes.getContractSignatureCertChain().getId(),
				generateDigest(certificateInstallationRes.getContractSignatureCertChain().getId(),
						messageHandler.getJaxbElement(certificateInstallationRes.getContractSignatureCertChain())));
		xmlSignatureRefElements.put(certificateInstallationRes.getContractSignatureEncryptedPrivateKey().getId(),
				generateDigest(certificateInstallationRes.getContractSignatureEncryptedPrivateKey().getId(),
						messageHandler
								.getJaxbElement(certificateInstallationRes.getContractSignatureEncryptedPrivateKey())));
		xmlSignatureRefElements.put(certificateInstallationRes.getDHpublickey().getId(),
				generateDigest(certificateInstallationRes.getDHpublickey().getId(),
						messageHandler.getJaxbElement(certificateInstallationRes.getDHpublickey())));
		xmlSignatureRefElements.put(certificateInstallationRes.getEMAID().getId(),
				generateDigest(certificateInstallationRes.getEMAID().getId(),
						messageHandler.getJaxbElement(certificateInstallationRes.getEMAID())));
		System.out.println("set xml signatureRef");
		// set signing private key
		ECPrivateKey signaturePrivateKey = (ECPrivateKey) readPrivateKeyFromFile(certData.getPrivateFileName());
		System.out.println("contract private Key:" + signaturePrivateKey.toString());
		// set Message
		byte[] sessionID = new byte[8];
		V2GMessage v2gMessage = messageHandler.getV2GMessage(sessionID, xmlSignatureRefElements, signaturePrivateKey,
				messageHandler.getJaxbElement(certificateInstallationRes));

		SendMessage sendMsg = new SendMessage(v2gMessage, 60000);
		byte[] payload = null;
		payload = (byte[]) messageHandler.v2gMsgToExi(sendMsg.getPayload());

		return payload;
	}
}
