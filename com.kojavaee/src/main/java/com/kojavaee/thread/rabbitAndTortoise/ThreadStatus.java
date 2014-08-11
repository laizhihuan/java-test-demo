package com.kojavaee.thread.rabbitAndTortoise;

public class ThreadStatus {
	public static void main(String[] args) {
		Runer runner = new Runer();
		
		Thread t = new Thread(runner);
		t.start();
		
		for(int i=0; i<1000; i++) {
			if(50==i) {
				runner.stop();
			}
			System.out.println("main run ------> " + i);
		}
		
	}
}

class Runer implements Runnable {
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			System.out.println("runner run .......");
		}
	}
	
	public void stop() {
		this.flag = false;
	}
	
}
