/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package interview.com.fayuan.singleton;

/**
 * 静态内部类写法的单例模式
 * 静态内部类中放了一个饿汉式的实例
 * 内部类只在外部类的getInstance()方法中被调用，所以只在getInstance()方法第一次被调用时加载
 * 由于静态内部类只会被加载一次，所以是线程安全的
 * 从静态内部类看是一个饿汉式，从外部看是一个懒汉式（真的想吐槽这个习惯说法）
 *
 * @author fayuan.fzw
 * @version $Id: Singleton5.java, v 0.1 2018年03月21日 上午12:30 fayuan.fzw Exp $
 */
public class Singleton5 {

    private static class Holder {
        private static Singleton5 instance = new Singleton5();
    }

    private Singleton5() {}

    public static Singleton5 getSingleton() {
        return Holder.instance;
    }
}