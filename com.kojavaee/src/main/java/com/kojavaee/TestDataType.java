package com.kojavaee;

public class TestDataType {
	
	public static void main(String[] args) {
		int a = 10;
		int a1 = 010;
		int a2 = 0x10;
		System.out.println(a);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toOctalString(a));
		System.out.println(Integer.toHexString(a));
		
		byte b2 = 100; //如果数据大小没有超过byte/short/char的表达范围，则可以自动转型
		
		long a7 = 112233322223L; //L问题，尽量大写L
		
	}
}
