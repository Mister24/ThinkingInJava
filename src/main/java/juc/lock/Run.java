/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2020 All Rights Reserved.
 */
package juc.lock;

/**
 * @author mr.24
 * @version Id: Run, v 1.0 2020/10/10 下午9:43 Exp $$
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread thread1 = new MyThread(service);
        MyThread thread2 = new MyThread(service);
        MyThread thread3 = new MyThread(service);
        MyThread thread4 = new MyThread(service);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
