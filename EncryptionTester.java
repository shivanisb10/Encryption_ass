package com.psl.Encryption.test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyPair;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import com.psl.Encryption.algorithm.AES256;
import com.psl.Encryption.algorithm.Keys;
import com.psl.Encryption.algorithm.RSA;

class EncryptionTester {

	@Test
	void testEncryptionStringResultsInExpectedByte() throws Exception {
        SecretKey secKey =Keys.getSymmetricKey();
		assertEquals(0, ((AES256.encryptText("", secKey)).length%16));
		assertEquals(0, ((AES256.encryptText("sbdisbfibiobfo", secKey)).length%16));
		
	}
	@Test
	void testSymmetricEncryptionDecryptionReverseEachOther() throws Exception
	{
		SecretKey k=Keys.getSymmetricKey();
		assertEquals("nothing", (AES256.decryptText(AES256.encryptText("nothing",k),k)));
	     k=Keys.getSymmetricKey();
		assertEquals("", (AES256.decryptText(AES256.encryptText("",k),k)));
	}
	@Test
	void testAsymmetricEncryptionReverseEachOther() throws Exception
	{
		KeyPair k=Keys.getAsymmetricKey();
		assertEquals("nothing", (RSA.decrypt(RSA.encrypt("nothing", k.getPublic()),k.getPrivate())));
	}
	@Test
	void testSignAndVerifyReverseEachOther() throws Exception
	{
		KeyPair k=Keys.getAsymmetricKey();
		assertEquals(true, RSA.verify("nothing", RSA.sign("nothing",k.getPrivate()),k.getPublic()));
	}
	@Test
	void keyGeneratorGeneratesRandomKeys()
	{
		
	}
	
}
