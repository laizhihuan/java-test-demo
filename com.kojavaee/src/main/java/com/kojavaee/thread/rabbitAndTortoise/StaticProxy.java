package com.kojavaee.thread.rabbitAndTortoise;

/**
 * 
 * @author zhihuanglai
 *
 */
public class StaticProxy {
	
	public static void main(String[] args) {
		Marry you = new You();
		MarryCompany company = new MarryCompany(you);
		company.marry();
	}
	
}

interface Marry {
	void marry();
}

class You implements Marry {

	@Override
	public void marry() {
		System.out.println("you and anky marry !!!!");
	}
	
}

class MarryCompany implements Marry {
	private Marry you;
	
	public MarryCompany(Marry you) {
		this.you = you;
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}

	private void after() {
		System.out.println("猪窝");
	}

	private void before() {
		System.out.println("打扫卫生");
	}
	
}