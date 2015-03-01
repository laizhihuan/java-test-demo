package com.kojavaee.guava;

import com.google.common.base.Objects;

public class GuavaObj {
    public static void main(String[] args) {
        boolean b1 = Objects.equal("a", "a"); // returns true
        boolean b2 = Objects.equal(null, "a"); // returns false
        boolean b3 = Objects.equal("a", null); // returns false
        boolean b4 = Objects.equal(null, null); // returns true
        
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
