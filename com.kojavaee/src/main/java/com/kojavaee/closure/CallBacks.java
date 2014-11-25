package com.kojavaee.closure;

interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable {
    private int i=0;
    
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
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
    
    //内部类closure实现了 incrementable,提供一个返回Callee2的“钩子” (hook)，而且是安全的钩子。
    //无论谁获得此Incrementable的引用，都只能调用increment(),除此之武器没有其他功能。
    private class Closure implements Incrementable {
        public void increment() {
            Callee2.this.increment();
        }
    }
    
    Incrementable getCallbackRefrerence() {
        return new Closure();
    }
}

//Caller的构造器需要一个Incrementable的引用作为参数(可以在任意时刻普获回调的引用)，
//然后在以后的某个时刻，Caller对象可以使用此引用回调Callee类
class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }
    void go() {
        callbackReference.increment();
    }
}

public class CallBacks {
    
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        //传参数时传入引用,这个引用就叫闭包
        MyIncrement.f(c2);
        
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackRefrerence());
        
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
