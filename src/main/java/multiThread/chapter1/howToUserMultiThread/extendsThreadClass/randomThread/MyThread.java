/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.howToUserMultiThread.extendsThreadClass.randomThread;

/**
 * @author mr.24
 * @version Id: MyThread, v 1.0 2019-06-13 23:42 Exp $$
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        //super.run();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            //TODO
            e.printStackTrace();
        }
    }
}
