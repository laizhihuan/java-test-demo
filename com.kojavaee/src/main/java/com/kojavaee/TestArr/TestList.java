package com.kojavaee.TestArr;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add(0, "a");
        list.add(1, "b");
        list.add(2, "c");
        list.add(3, "d");
        
        String value1 = list.get(0);
        String value3 = list.get(2);
    }
}
