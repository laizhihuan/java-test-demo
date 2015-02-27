package com.kojavaee.guava;

import com.google.common.base.Joiner;

public class GuavaAPI {
    public static void main(String[] args) {
        //[1,2,3]拼接成1 2 3
        String outputStr = Joiner.on(' ').join(1,2,3);
        System.out.println(outputStr);
        
    }
}
