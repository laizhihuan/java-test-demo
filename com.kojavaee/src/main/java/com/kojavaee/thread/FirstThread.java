package com.kojavaee.thread;

public class FirstThread {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("create , run ......");
            }
        }.start();
        System.out.println("main process end .....");
    }
}
