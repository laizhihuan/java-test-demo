/**
 * Project Name:com.kojavaee
 * File Name   :TestStatic.java
 * Package Name:com.kojavaee
 * Date        :2014年5月29日上午10:55:44
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
*/

package com.kojavaee;

import java.util.Arrays;

/**
 * ClassDesc:TODO Add desc<br/>
 * Function :TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年5月29日 上午10:55:44 <br/>
 * @author   lzh
 * @version  
 * @see 	 
 */
public class TestStatic {
	public final static int[] TEST= {1,2,3,4,5,6,7};
	public static void main(String[] args) {
		int[] def = TEST;
		for (int i = 0; i < def.length; i++) {
			def[i] = 0;
		}
		System.out.println(Arrays.toString(TEST));
	}
}
