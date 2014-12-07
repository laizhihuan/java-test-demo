package com.kojavaee.test;

public class TestOutput {
	static int[] a = new int[3];

	public static void main(String[] args) throws Exception
	{
		for (int i = 0; i < 3; i++) 
		{
			Chek(i*2);
		}
	}

	static void Chek(int b)
	{
		for (int i = a.length; i > 0; i--) 
		{
			a[i-1]+=b+i;
			System.out.println("aa :"+a[i-1]);
		}
	} 
}
