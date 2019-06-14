/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.howToUserMultiThread.implementRunnableInterface;

/**
 * @author mr.24
 * @version Id: Test, v 1.0 2019-06-14 16:00 Exp $$
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println("运行结束！");
    }
}
