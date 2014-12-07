package com.kojavaee.test;

public class TestCharType {
	public static void main(String[] args) {
		char c1 = 'a';
		char c2 = '赖';
		char c3 = '\'';
		char c4 = '\\';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		char c5 = 'a';
		int i = c5 + 2; //字符可以当做整数来用
		
		System.out.println(i);
		
		//打印a-z
		for(int j=0;j<26;j++) {
			char temp = (char)(c5+j);
			System.out.println(temp);
		}
	}
}
