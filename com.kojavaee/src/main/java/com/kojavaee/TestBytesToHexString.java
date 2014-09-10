package com.kojavaee;


public class TestBytesToHexString {
	
	private static String bytesToHexString(byte[] src) {
		StringBuilder result = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			
			String hv = Integer.toHexString(v);
			
			if (hv.length() < 2) {
				result.append(0);
			}
			result.append(hv);
		}
		return result.toString();
	}
}
