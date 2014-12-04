package com.kojavaee;

public class TestOperator {
	
	public static void main(String[] args) {
		double d = 10.2%3;
		System.out.println(d);
		
		int a = 3;
		int b = a++; //b = a , a++
		System.out.println(a);
		
		int c = ++a;
		System.out.println(b);
		System.out.println(c);
		
		int m = 7;
		int n = 3;
		System.out.println(~m);   //取反    1000 -8 
		System.out.println(m&n);  //按位与   0011 3
		System.out.println(m|n);  //按位或   0111 7
		System.out.println(m^n);  //按位异或  0100 4
		
		int i = 3 * 2 * 2;
		int j = 3 << 2;    // 左移
		int k = 12/2/2;
		int p = 12 >> 2;   // 右移
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(p);
		
		int count = 2000;
		System.out.println(count%1000);
		
	}
}
