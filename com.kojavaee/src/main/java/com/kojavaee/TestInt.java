/**
 * Project Name:com.kojavaee
 * File Name   :TestInt.java
 * Package Name:com.kojavaee
 * Date        :2014年6月6日下午2:46:36
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
*/

package com.kojavaee;


/**
 * ClassDesc:TODO Add desc<br/>
 * Function :TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年6月6日 下午2:46:36 <br/>
 * @author   lzh
 * @version  
 * @see 	 
 */
public class TestInt {
//	public static void main(String[] args) {
////		System.out.println((int)1.4);
////		System.out.println((int)1.5);
////		System.out.println((int)1.6);
//		
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
////		map.put(1,1);
//		int a = map.get(1);
//		System.err.println(a);
//		System.err.println(map.get(2));
//	}
	
//	String str;
//	int i;
//	
//	public String toString(){
//		return str+i+this;
//	}
//	
//	public static void main(String[] args) {
//		new TestInt().toString();
//	}
	private int i=getValue();
	private int j=10;
	public int getValue() {
		return j;
	};
	public static void main(String[] args) {
		System.out.println(new TestInt().i);
		System.out.println(new TestInt().j);
		System.out.println(new TestInt().getValue());
	}
	
}
