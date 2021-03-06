package com.kojavaee.guava.cache;

/**
 * guava缓存配置
 * @author zhihuanglai
 *
 */
public interface CacheConfig {
	int maxinumSize = 10;
	int refreshAfterWrite = 12;
	int expireAfterWrite = 12;
}
