/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.singleton;

/**
 * 饿汉式
 * 第一次引用该类的时候就创建实例，而不管实际是否需要创建
 *
 * @author fayuan.fzw
 * @version $Id: Singleton1.java, v 0.1 2018年03月20日 下午11:13 fayuan.fzw Exp $
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}