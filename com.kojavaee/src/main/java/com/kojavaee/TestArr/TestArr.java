package com.kojavaee.TestArr;

public class TestArr {
    public static void main(String[] args) {
        String[] arr = new String[] {"a","b","c","d"};
        String value1 = arr[0];
        String value3 = arr[2];
        arr[2] = value1;
        arr[0] = value3;
        for(int i=0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
