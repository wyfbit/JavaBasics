package com.amc.basicknowledge.javasecurity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String beforeDegist="asdf";
		System.out.println("摘要前："+beforeDegist);
		
		//初始信息要转换成字节流的形式
		byte[] plainText=beforeDegist.getBytes("UTF8");
		
		//使用getInstance（“算法”）来获得消息摘要，这里使用SHA-1的160位算法或者MD5算法
		MessageDigest messageDigest=MessageDigest.getInstance("SHA-1");
		//MessageDigest messageDigest=MessageDigest.getInstance("MD5");
		
		System.out.println("/n"+messageDigest.getProvider().getInfo());
		
		//开始使用算法
		messageDigest.update(plainText);
		//输出算法运算结果
		String afterDegist=new String(messageDigest.digest(),"UTF8");
		System.out.println("摘要后："+afterDegist);
	}

}
