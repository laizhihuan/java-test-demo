package com.kojavaee.guava;

import com.google.common.base.Preconditions;


/**
 * guava 提供的前置条件判断
 * @author zhihuanglai
 *
 */
public class GuavaPre {
    
    public static void main(String[] args) {
        int i = 1;
        int j = -2;
        Preconditions.checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
        Preconditions.checkArgument(i < j, "Expected i < j, but %s > %s", i, j);
    }
}
