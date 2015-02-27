package com.kojavaee.guava;

import com.google.common.base.Joiner;

public class GuavaAPI {
    public static void main(String[] args) {
        //[1,2,3]拼接成1 2 3
        String outputStr = Joiner.on(' ').join(1,2,3);
        
        String outputStr1 = Joiner.on(' ').skipNulls().join(1,null,3);
        String outputStr2 = Joiner.on(' ').useForNull("none").join(1,null,3);
        
        
        System.out.println(outputStr);
        System.out.println(outputStr1);
        System.out.println(outputStr2);
    }
}
