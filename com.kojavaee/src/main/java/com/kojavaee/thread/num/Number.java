package com.kojavaee.thread.num;

public class Number {
	
	public static void main(String[] args) {
		
	}
}

class Counter implements Runnable {
	private int counter = 30;
	private String name;
	
	
	public Counter(String name) {
		this.name = name;
	}
	
	public void run() {
		int num = 0;
		if(num >= counter) {
			System.out.println(name + ":" + num++);
		}
	}
	
}
