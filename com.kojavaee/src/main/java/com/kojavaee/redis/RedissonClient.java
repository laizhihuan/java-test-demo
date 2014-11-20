
package com.kojavaee.redis;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RSet;
import org.redisson.core.RSortedSet;

/**
 * redisson的客户端测试
 * 
 * @author lzh
 */
public class RedissonClient {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("168.168.3.59:6379");

        Redisson redisson = Redisson.create(config);
        
        long s = System.nanoTime();
        RSet<String> set = redisson.getSet("anySet");
        set.add("a");
        
        long e = System.nanoTime();
        System.out.println("need time" + (e - s)/1000000);
        
        long s1 = System.nanoTime();
        RSortedSet rss = redisson.getSortedSet("rs");
        rss.add("ddddddddddd");
        long e1 = System.nanoTime();
        
        System.out.println("need time" + (e1 - s1)/1000000 + " ms");
        
    }
}
