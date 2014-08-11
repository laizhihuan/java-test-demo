/**
 * Project Name:com.kojavaee
 * File Name   :TestCalendar.java
 * Package Name:com.kojavaee.calendar
 * Date        :2014年5月22日上午8:56:50
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
 */

package com.kojavaee.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassDesc:TODO Add desc<br/>
 * Function :TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014年5月22日 上午8:56:50 <br/>
 * 
 * @author lzh
 * @version
 * @see
 */
public class TestCalendar {
	/**
	 * 得到本周周一
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getMondayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	public static Date getNextMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if (week > 2) {
			cal.add(Calendar.DAY_OF_MONTH, -(week - 2) + 7);
		} else {
			cal.add(Calendar.DAY_OF_MONTH, 2 - week + 7);
		}
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(getMondayOfThisWeek());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println(getNextMonday(getNextMonday(getNextMonday(getNextMonday(sdf.parse("2013-01-01"))))));
			System.out.println(sdf.format(getNextMonday(sdf.parse("2013-12-30"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
