/**
 * Project Name:com.kojavaee
 * File Name   :TestTask.java
 * Package Name:com.kojavaee
 * Date        :2014年5月24日下午6:03:48
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
*/

package com.kojavaee;
/**
 * Date:     2014年5月24日 下午6:03:48 <br/>
 * @author   lzh
 * @version  
 * @see 	 
 */
public class TestTask {

	public static void main(String[] args) {
		boolean result = false;
		update(result);
		System.out.println(result);
		if(result) {
			System.out.println("true");
		}
	}
	/**
	 * 
	 * update:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @param result
	 */
	private static void update(boolean result) {
		result = true;
	}

}
