package com.kojavaee.thread;

public class NoVisiabilityTest {
    
    private static class ReadThread extends Thread {
        private boolean ready;
        
        private int number;
        
        @Override
        public void run() {
            //并发模型中的可见性问题, run会一直run
            while(!ready) {
                number++;
            }
            System.out.println(ready);
        }
        
        public void readyOn() {
            this.ready = true;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();
        Thread.sleep(200);
        rt.readyOn();
        System.out.println(rt.ready);
    }
    
}
