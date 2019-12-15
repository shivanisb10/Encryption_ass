package com.psl.Encryption.algorithm;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Keys {
	
	public static KeyPair getAsymmetricKey()
	{
		KeyPairGenerator keyPairGenerator;
		KeyPair pair = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1028);
			pair = keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pair;
	}
	
	public static SecretKey getSymmetricKey()
	{
		KeyGenerator generator;
		SecretKey secKey = null;
		try {
			generator = KeyGenerator.getInstance("AES");
			generator.init(256); // The AES key size in number of bits
              secKey = generator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secKey;
	}

}
