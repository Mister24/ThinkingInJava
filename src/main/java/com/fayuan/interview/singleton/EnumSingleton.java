/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.singleton;

/**
 *
 * @author fayuan.fzw
 * @version $Id: EnumSingleton.java, v 0.1 2018年04月14日 下午8:57 fayuan.fzw Exp $
 */
public class EnumSingleton {

    private EnumSingleton(){}

    public static EnumSingleton getInstance(){

        return Singleton.INSTANCE.getSingleton();
    }

    private static enum Singleton {

        INSTANCE;

        private EnumSingleton singleton;

        private Singleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getSingleton() {
            return singleton;
        }

    }
}