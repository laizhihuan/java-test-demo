package com.kojavaee.thread;

public class ThreadJoinTest {
    
    static class Computer  extends Thread {
        private int start;
        private int end;
        private int result;
        private int[] array;
        
        public Computer(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public void run() {
            for(int i=start; i<end; i++) {
                result += array[i];
                if(result < 0) result &= Integer.MAX_VALUE;
            }
        }
        
        public int getResult() {
            return result;
        }
    }
    
    
    
}
