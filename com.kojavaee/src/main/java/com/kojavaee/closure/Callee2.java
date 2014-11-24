package com.kojavaee.closure;


public class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    
    private class Closure implements Incrementable {
        public void increment() {
            Callee2.this.increment();
        }
        
        Incrementable getCallbackRefrerence() {
            return new Closure();
        }
    }
}
