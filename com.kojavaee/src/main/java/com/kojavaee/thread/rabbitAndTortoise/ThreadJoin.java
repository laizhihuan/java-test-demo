package com.kojavaee.thread.rabbitAndTortoise;

public class ThreadJoin extends Thread {
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("thread run ......"+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadJoin join = new ThreadJoin();
		Thread t = new Thread(join);
		t.start();
		
		for(int i=0; i<1000; i++) {
			if(i == 50) {
				t.join();
			}
			System.out.println("main run ....." + i);
		}
	}
}
