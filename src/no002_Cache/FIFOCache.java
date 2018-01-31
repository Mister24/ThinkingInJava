/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package no002_Cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 *
 * @author mr.24
 * @version $Id: FIFOCache.java, v 0.1 2018年01月26日 上午12:21 mr.24 Exp $
 */
public class FIFOCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 5841154213605633340L;

    private final int SIZE;

    public FIFOCache(int size) {
        super();
        SIZE = size;
    }

    //重写淘汰机制
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > SIZE;
    }

    
}