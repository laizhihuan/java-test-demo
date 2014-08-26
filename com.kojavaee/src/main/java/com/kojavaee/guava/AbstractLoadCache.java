package com.kojavaee.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public abstract class AbstractLoadCache<K,V> {
	
	LoadingCache<K, V> cache = CacheBuilder.newBuilder()
			.maximumSize(CacheConfig.maxinumSize).refreshAfterWrite(CacheConfig.refreshAfterWrite, TimeUnit.HOURS)
			.build(new CacheLoader<K, V>() {

				@Override
				public V load(K key) throws Exception {
					return getData(key);
				}
				
			});

	public abstract V getData(K key);
	
	public LoadingCache<K, V> getCache() {
		return cache;
	}
	
	public void setCache(LoadingCache<K, V> cache) {
		this.cache = cache;
	}
}
