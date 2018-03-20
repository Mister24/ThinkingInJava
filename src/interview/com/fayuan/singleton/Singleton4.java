/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package interview.com.fayuan.singleton;

/**
 * 双重检验版本的单例模式
 * 由于单例中需要new出实例的情况非常少，绝大多数情况下多个线程不需要进行锁等待
 * 因此在加锁前进行判空，从而减少绝大多数的加锁操作，提高执行效率
 *
 * @author fayuan.fzw
 * @version $Id: Singleton4.java, v 0.1 2018年03月21日 上午12:16 fayuan.fzw Exp $
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {}

    public static Singleton4 getInstance() {

        if (null == instance) {
            synchronized (Singleton4.class) {

                if (null == instance) {

                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }
}