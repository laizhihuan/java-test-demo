package com.kojavaee.guava.eventbus;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class TestEventBus {
    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
    }
}

//输出信息
//event message:200
//Message:200
//event message:300
//Message:300
//event message:400
//Message:400
//LastMessage:400