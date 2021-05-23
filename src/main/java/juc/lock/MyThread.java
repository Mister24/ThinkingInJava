/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2020 All Rights Reserved.
 */
package juc.lock;

/**
 * @author mr.24
 * @version Id: MyThread, v 1.0 2020/10/10 下午9:42 Exp $$
 */
public class MyThread extends Thread {

    private MyService service;

    public MyThread(MyService service) {
        super();
        this.service = service;

    }

    @Override
    public void run() {
        service.testMethod();
    }
}
