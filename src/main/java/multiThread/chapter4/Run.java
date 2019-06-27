/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter4;

/**
 * @author mr.24
 * @version Id: Run, v 1.0 2019-06-27 00:34 Exp $$
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        Thread myThread = new Thread(new MyThread(myService));
        Thread myThread1 = new Thread(new MyThread(myService));

        myThread.start();
        myThread1.start();
    }
}
