/**
 * Project Name:com.kojavaee
 * File Name   :TestException.java
 * Package Name:com.kojavaee.exception
 * Date        :2014年5月21日下午1:54:04
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
*/

package com.kojavaee.exception;
/**
 * ClassDesc:TODO Add desc<br/>
 * Function :TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年5月21日 下午1:54:04 <br/>
 * @author   lzh
 * @version  
 * @see 	 
 */
public class TestException {
	public static void main(String[] args) {
		try {
			throw new Exception("put in cache fail");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sssss"+e);
		}
	}
}
