/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2020 All Rights Reserved.
 */
package juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mr.24
 * @version Id: LockCase, v 1.0 2020/9/14 下午11:42 Exp $$
 */
public class LockCase extends Thread {

    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockCase lockCase = new LockCase();
        Thread thread = new Thread(lockCase);
        Thread thread1 = new Thread(lockCase);
        thread.start();
        thread1.start();
    }

    public void add() {
        lock.lock();
        try {
            for (int i = 0; i < 98; i++) {
                System.out.println(i + " : " + Thread.currentThread().getName());
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        add();
    }
}
