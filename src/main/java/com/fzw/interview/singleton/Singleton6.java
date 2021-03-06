/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.singleton;

/**
 * 枚举写法的单例模式
 *
 * @author fzw.fzw
 * @version $Id: Singleton6.java, v 0.1 2018年03月21日 下午12:35 fzw.fzw Exp $
 */
public enum Singleton6 {

    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}