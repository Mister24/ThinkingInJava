/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.howToUserMultiThread.implementRunnableInterface;

/**
 * @author mr.24
 * @version Id: MyRunnable, v 1.0 2019-06-14 15:49 Exp $$
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中！");
    }
}
