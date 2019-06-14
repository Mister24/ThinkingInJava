/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.howToUserMultiThread.extendsThreadClass.randomThread.thread;

/**
 * @author mr.24
 * @version Id: MyThread, v 1.0 2019-06-14 15:34 Exp $$
 */
public class MyThread extends Thread {
    private int i;

    public MyThread(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
