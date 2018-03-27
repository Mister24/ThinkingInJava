/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.list;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 最近最少使用算法
 *
 * @author fayuan.fzw
 * @version $Id: LRUCache.java, v 0.1 2018年03月27日 下午5:03 fayuan.fzw Exp $
 */
public class LRUCache<K, V> {

    private int cacheSize;

    private float loadFactor = 0.75f;

    private Map<K, V> cache;

    private final Lock lock = new ReentrantLock();

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;

        //根据cacheSize和加载因子计算HashMap的capactiy,+1确保当达到cacheSize上限时不会触发HashMap的扩容
        int capacity = (int) Math.ceil(cacheSize / loadFactor) + 1;

        this.cache = new LinkedHashMap<K, V>(capacity, loadFactor, true) {

            // 定义put后的移除规则,大于容量就删除eldest
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return cache.containsKey(key);
        } finally {
            lock.unlock();
        }
    }


    public V get(Object key) {
        try {
            lock.lock();
            return cache.get(key);
        } finally {
            lock.unlock();
        }
    }

    public V put(K key, V value) {
        try {
            lock.lock();
            return cache.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return cache.size();
        } finally {
            lock.unlock();
        }
    }

}