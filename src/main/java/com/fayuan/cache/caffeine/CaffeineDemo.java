/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.fzw.cache.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;

import java.util.concurrent.TimeUnit;

/**
 * @author mr.24
 * @version Id: CaffeineDemo, v 1.0 2020/5/16 下午2:51 Exp $$
 */
public class CaffeineDemo {
    public static void main(String[] args) {
        // 1、最简单
//        Cache<String, Object> cache = Caffeine.newBuilder().build();

                //Caffeine.newBuilder().build();
        // 2、真实使用过程中我们需要自己配置参数。这里只列举部分，具体请看下面列表
//        Cache<String, Object> cache = Caffeine.newBuilder()
//                //初始大小
//                .initialCapacity(2)
//                //最大数量
//                .maximumSize(2)
//                //过期时间
//                .expireAfterWrite(3, TimeUnit.SECONDS)
//                .build();
    }
}
