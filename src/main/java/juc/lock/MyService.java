/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2020 All Rights Reserved.
 */
package juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mr.24
 * @version Id: MyService, v 1.0 2020/10/10 下午9:40 Exp $$
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    /**
     * 验证lock
     */
    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " " + (i + 1));
        }
        lock.unlock();
    }
}
