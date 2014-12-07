package com.kojavaee.test;

public class TestBytesToHexString {
	
	/**
	 * 计算机中的数字都是按2进制存储的,int类型的数字占32个bit位
	 * 这个代码是通用的 
	 * 		num就是你要转化的数字 
	 * 		base是参与位运算的数字,base = 15  
	 *      offset是一次运算,offset = 4
	 * @param num
	 * @param base
	 * @param offset
	 * @return
	 */
	public static String toHexString(int num, int base, int offset) {
		if (num == 0) {
			return "0";
		}
		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };// 定义对应表
		char[] res = new char[32];  //Int类型32位bit
		int pose = res.length;      //当前所在数组位置指针
		while (num != 0) {
			int temp = num & base;  //最低位与运算
			res[--pose] = arr[temp]; //保存转换后的低位
			num = num >>> offset;    //次低位移动到最低位
		}
		String st = new String(res);
		return st.trim();
	}

	private static String bytesToHexString(byte[] src) {
		StringBuilder result = new StringBuilder("");
		
		if (src == null || src.length <= 0) {
			return null;
		}
		
		for (int i = 0; i < src.length; i++) { //遍历byte数组
			
			int v = src[i] & 0xFF; //byte与1111 1111做与运算

			System.out.println(v);

			String hv = toHexString(v, 15, 4); //将10进制转成16进制

			System.out.println(hv);

			if (hv.length() < 2) { //将16进制数，如果不足两位，前面补0, eg: 8,-> 08
				result.append(0);
			}
			result.append(hv);
		}
		return result.toString();
	}
	
	private static String bytesToHexStr(byte[] src) {
		StringBuilder result = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF; 

			System.out.println(v);

			String hv = Integer.toHexString(v);

			System.out.println(hv);

			if (hv.length() < 2) {
				result.append(0);
			}
			result.append(hv);
		}
		return result.toString();
	}

	public static void main(String[] args) {
//		char a = 65;
//		char b = 104;
//		System.out.println(a);  //输出 A
//		System.out.println(b); //输出 h
		System.out.println(bytesToHexString("hello".getBytes())); //输出: 68656c6c6f
		System.out.println(bytesToHexStr("hello".getBytes()));    //输出: 68656c6c6f
	}
}
