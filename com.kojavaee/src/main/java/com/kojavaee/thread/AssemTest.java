
package com.kojavaee.thread;

public class AssemTest {
    int a, b;
    volatile int c, d;
    
    private void test() {
        a = 1;
        b = 2;
        c = a;
        d = b;
        b = 3;
        c = 2;
    }
    
    public static void main(String[] args) {
        new AssemTest().test();
    }
}
