package com.kojavaee;

public class TestVariable {
	int t; //实例变量
	
	public static void main(String[] args) {
		String aaa = "#有中文吗";
		String bbb = "#aaaa";
		System.out.println(aaa.startsWith("#"));
		System.out.println(bbb.startsWith("#"));
		bbb.startsWith("#");
	}
}
