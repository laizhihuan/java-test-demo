/**
 * Project Name:com.kojavaee
 * File Name   :SimpleQuartzJob.java
 * Package Name:com.kojavaee.quartz
 * Date        :2014年5月20日下午4:28:59
 * Copyright (c) 2014, www.19game.cn All Rights Reserved.
 *
*/

package com.kojavaee.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时器测试 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年5月20日 下午4:28:59 <br/>
 * @author   lzh
 * @version  
 * @see 	 
 */
public class SimpleQuartzJob implements Job {

    public SimpleQuartzJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("In SimpleQuartzJob - executing its JOB at " 
                + new Date() + " by " + context.getTrigger().getEndTime());
    }
}