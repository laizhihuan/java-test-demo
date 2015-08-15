package com.kojavaee.guava.eventbus;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class TestMultipleEvents {
    
    @Test  
    public void testMultipleEvents() throws Exception {  
       
        EventBus eventBus = new EventBus("test");  
        MultipleListener multiListener = new MultipleListener();  
       
        eventBus.register(multiListener);  
       
        eventBus.post(new Integer(100));
        eventBus.post(new Integer(200));  
        eventBus.post(new Integer(300));  
        eventBus.post(new Long(800)); 
        eventBus.post(new Long(800990));  
        eventBus.post(new Long(800882934));  
       
        System.out.println("LastInteger:"+multiListener.getLastInteger());
        System.out.println("LastLong:"+multiListener.getLastLong());
    }   
}

//输出信息
//event Integer:100
//event Integer:200
//event Integer:300
//event Long:800
//event Long:800990
//event Long:800882934
//LastInteger:300
//LastLong:800882934
