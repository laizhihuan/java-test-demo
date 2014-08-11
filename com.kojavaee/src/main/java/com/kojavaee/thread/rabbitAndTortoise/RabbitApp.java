package com.kojavaee.thread.rabbitAndTortoise;

public class RabbitApp {
	
	public static void main(String[] args) {
		Rabbit rabbit = new Rabbit();
		Tortoise tor = new Tortoise();
		//等CPU的调用run方法执行
		rabbit.start();
		tor.start();
		
		for(int i=0; i<1000; i++) {
			System.out.println("main==>"+i);
		}
	}
	
}
