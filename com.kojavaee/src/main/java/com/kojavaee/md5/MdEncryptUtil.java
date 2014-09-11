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
		byte[] result = MD5Encode("hzm123456");
		System.out.print("md5:");
		for (byte b : result) {
			System.out.print(b);
			System.out.print(",");
		}
		System.out.println();
		System.out.print("hex:");
		String value = bytesToHexString(result);
		System.out.println();
		System.out.println(value);
	}
}
