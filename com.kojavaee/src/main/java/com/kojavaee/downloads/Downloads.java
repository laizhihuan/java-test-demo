package com.kojavaee.downloads;

public class Downloads {
	
	public static void main(String[] args) {
		int sn = 10000;
		int a1 = 100;
		int n = 30;
		int an = 2*sn/n -a1;
		double d = (an - a1)/(n-1);
		
		double total = 0;
		for(int i=1; i<=n; i++) {
			double ai = a1 + (i-1)*d;
			total += ai;
			System.out.println("n: " + i + "  " + ai);
		}
		System.out.println(total);
		System.out.println("d " + d + " an " + an);
	}
}
