package com.kojavaee.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Race {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		Game rabbit = new Game("兔子",5);
		Game tortoise = new Game("乌龟",10);
		Future<Integer> result1 = exec.submit(rabbit);
		Future<Integer> result2 = exec.submit(tortoise);
		
		Thread.sleep(20);
		rabbit.setFlag(false);
		tortoise.setFlag(false);
		
		Integer step1 = result1.get();
		Integer step2 = result2.get();
		
		System.out.println("兔子跑了："+step1);
		System.out.println("乌龟跑了："+step2);
		
		exec.shutdown();
	}
	
}

class Game implements Callable<Integer> {
	private String name;
	private long time;
	private int step;
	private boolean flag = true;
	
	public Game(String name, long time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public Integer call() throws Exception {
		while(flag) {
			Thread.sleep(time);
			step++;
		}
		return step;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
}