package com.kojavaee.thread.rabbitAndTortoise;

public class Rabbit extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("兔子跑了" + i + "步");
		}
	}
}

class Tortoise extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("乌龟跑了" + i + "步");
		}
	}
}




