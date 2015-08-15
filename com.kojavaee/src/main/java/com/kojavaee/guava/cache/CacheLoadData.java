package com.kojavaee.guava.cache;

import java.util.concurrent.ExecutionException;

public class CacheLoadData extends AbstractLoadCache<String, String>{
	
	@Override
	public String getData(String key) {
		System.out.println("getData method ....");
		return "{key"+key + ",value:"+key+"}";
	}
	
	public static void main(String[] args) throws ExecutionException {
		CacheLoadData loadData = new CacheLoadData();
		for(int i=0;i<5; i++) {
			String str = loadData.cache.get("ko");
			System.out.println(str);
		}
	}
}
