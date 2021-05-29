/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.basicjava.no002_Cache;

/**
 *
 * @author mr.24
 * @version $Id: FIFOCacheTest.java, v 0.1 2018年01月26日 上午12:33 mr.24 Exp $
 */
public class FIFOCacheTest {
    public static void main(String[] args) {
        FIFOCache<Integer, Integer> map = new FIFOCache<Integer, Integer>(5);
        for (int i = 0; i ++ < 10;) {
            map.put(i, i);
        }
        //System.out.println("初始存储情况：" + map.toString);
    }
}