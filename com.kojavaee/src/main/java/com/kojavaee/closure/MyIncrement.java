package com.kojavaee.closure;



public class MyIncrement implements Incrementable {
    public void increment() {
        System.out.println("Other operation");
    }
    
    static void f(MyIncrement mi) {
        mi.increment();
    }
}

