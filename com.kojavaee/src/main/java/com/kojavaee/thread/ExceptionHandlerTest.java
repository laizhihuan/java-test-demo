package com.kojavaee.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandlerTest {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Integer.parseInt("ABC");
            }
        };
        
        t.setUncaughtExceptionHandler(new TestExceptionHandler());
        t.start();
    }
}

class TestExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thread exception : ");
        e.printStackTrace();
    }
}