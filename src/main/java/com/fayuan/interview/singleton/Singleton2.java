/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.singleton;

/**
 * 单线程懒汉式（可以延迟加载，但线程不安全）
 * 私有构造器 + 公有静态工厂方法
 * 在工厂方法中对单例进行判空，如果为null，则新建
 * 问题：如果多个线程同时调用工厂方法，很可能导致重复创建对象，所以线程不安全
 *
 * @author fzw.fzw
 * @version $Id: Singleton2.java, v 0.1 2018年03月20日 下午11:18 fzw.fzw Exp $
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {

        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}