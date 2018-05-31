/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.singleton;

/**
 * 线程安全(线程锁效率低)
 * 使用synchronized进行加锁，某个线程获得锁之后，其他线程需等待，不会重复创建instance
 * 问题：其他线程在等待锁的时候，会导致程序效率下降
 *
 * @author fayuan.fzw
 * @version $Id: Singleton3.java, v 0.1 2018年03月20日 下午11:38 fayuan.fzw Exp $
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {

        if (null == instance) {
            instance = new Singleton3();
        }

        return instance;
    }
}