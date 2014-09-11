package com.kojavaee.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MdEncryptUtil {
	/**
	 * 把字节数组转换成16进制字符串
	 * 
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			int value = 0xFF & bArray[i];
			System.out.println();
			System.out.print(value);
			System.out.print(",");
			sTemp = Integer.toHexString(value);

			System.out.print("-> ");
			System.out.print(sTemp);
			System.out.print(",");

			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * MD5加密字符串，返回加密后的16进制字符串
	 * 
	 * @param origin
	 * @return
	 */
	public static final String MD5EncodeToHex(String origin) {
		return bytesToHexString(MD5Encode(origin));
	}

	/**
	 * MD5加密字符串，返回加密后的字节数组
	 * 
	 * @param origin
	 * @return
	 */
	public static final byte[] MD5Encode(String origin) {
		return MD5Encode(origin.getBytes());
	}

	/**
	 * MD5加密字节数组，返回加密后的字节数组
	 * 
	 * @param bytes
	 * @return
	 */
	public static final byte[] MD5Encode(byte[] bytes) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			return md.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}

	public static void main(String[] args) {
		String pwd="hzm123456";
		String salt="5311981083002945899";
		String msg = pwd+salt+pwd+salt+pwd+pwd; //121211形式加密
		byte[] result = MD5Encode(msg);  //MD5加密字节数组，返回加密后的字节数组
		System.out.print("md5:");
		for (byte b : result) {
			System.out.print(b);
			System.out.print(",");
		}
		System.out.println();
		System.out.print("hex:");
		String value = bytesToHexString(result); //把 [MD5加密字节数组，返回加密后的字节数组] 转换成16进制字符串
		System.out.println();
		System.out.println(value.toLowerCase()); //转成小写,结果: 1f3855ebb4e3b687e72c811f98f379f6
		System.out.println();
		System.out.println(MD5EncodeToHex(msg).toLowerCase()); //MD5加密字符串，返回加密后的16进制字符串,最后转成小写,结果:1f3855ebb4e3b687e72c811f98f379f6
		
	}
}
