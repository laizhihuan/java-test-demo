package com.kojavaee.closure;


public class Callee1 implements Incrementable {
    private int i=0;
    
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
    
    static class MyIncrement {
        public void increment() {
            System.out.println("Other operation");
        }
        
        static void f(MyIncrement mi) {
            mi.increment();
        }
    }
    
    class Callee2 extends MyIncrement {
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

}
