/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.chapter1_2_howToUserMultiThread;

/**
 * @author mr.24
 * @version Id: MyThread, v 1.0 2019-06-13 23:38 Exp $$
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
