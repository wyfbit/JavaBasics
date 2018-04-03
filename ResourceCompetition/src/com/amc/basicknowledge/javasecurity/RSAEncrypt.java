package com.amc.basicknowledge.javasecurity;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAEncrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		String before = "asdf";           
	       byte[] plainText = before.getBytes("UTF8");    
	           
	       //产生一个RSA密钥生成器KeyPairGenerator(顾名思义：一对钥匙生成器)    
	       KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");    
	  
	  
	       //定义密钥长度1024位    
	       keyGen.initialize(1024);    
	  
	  
	       //通过KeyPairGenerator产生密钥,注意：这里的key是一对钥匙！！    
	       KeyPair key = keyGen.generateKeyPair();    
	       System.out.println("公钥:"+key.getPublic().toString());
	       
	       //获得一个RSA的Cipher类，使用公钥加密    
	       Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");    
	//System.out.println("/n" + cipher.getProvider().getInfo());    
	  
	       System.out.println("用公钥加密...");    
	  
	  
	       //Cipher.ENCRYPT_MODE意思是加密，从一对钥匙中得到公钥 key.getPublic()    
	       cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());    
	  
	  
	       //用公钥进行加密，返回一个字节流    
	       byte[] cipherText = cipher.doFinal(plainText);    
	  
	  
	       //以UTF8格式把字节流转化为String    
	       String after1 = new String(cipherText, "UTF8");    
	  
	  
	       System.out.println("用公钥加密完成："+after1);    
	  
	           
	       //使用私钥解密    
	       System.out.println("用私钥解密...");    
	  
	       System.out.println("私钥:"+key.getPrivate().toString());
	       //Cipher.DECRYPT_MODE意思是解密模式，从一对钥匙中得到私钥 key.getPrivate()    
	       cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());    
	  
	  
	       //用私钥进行解密，返回一个字节流    
	       byte[] newPlainText = cipher.doFinal(cipherText);    
	  
	       String after2 = new String(newPlainText, "UTF8");    
	       System.out.println("用私钥解密完成："+after2);   
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
