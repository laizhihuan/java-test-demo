package com.kojavaee.test;

import java.util.Random;

/**
 * 利用case穿透，实现语言特性
 * 
 * jdk7新特性,增强了switch可以是字符窜
 * 
 * @author zhihuanglai
 *
 */
public class TestSwitch {
	
	//忘了加break会发生case穿透
	public static void main(String[] args) {
		char c = 'a';
		Random random = new Random();
		int rand = random.nextInt(26);
		char c2 = (char)(c+rand);
		System.out.print(c2 + ": ");
		
		switch (c2) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.print("元音");
			break;
		case 'y':
		case 'w':
			System.out.print("半元音");
			break;
		default:
			System.out.print("铺音");
			break;
		}
		
		
	}
	
}
