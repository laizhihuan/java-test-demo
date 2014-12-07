/**
 * Project Name:com.kojavaee
 * File Name   :TestDouble.java
 * Package Name:com.kojavaee
 * Date        :2014年6月3日下午3:24:20
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
*/

package com.kojavaee.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Date:     2014年6月3日 下午3:24:20 <br/>
 * @author   lzh
 * @version  
 * @see 	 
 */
public class TestDouble {
	public static void main(String[] args) {
//		double d = 0.0;
//		if(d == 0) {
//			System.out.println("double is 0");
//		}
		DecimalFormat df1 = new DecimalFormat("0.0000");
		BigDecimal b = new BigDecimal(1.0d);
		BigDecimal b2 = new BigDecimal(3658d);
		BigDecimal result = b.divide(b2);
		System.out.println(result.toString());
	}
}
