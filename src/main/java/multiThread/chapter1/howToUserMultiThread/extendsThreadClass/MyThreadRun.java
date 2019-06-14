/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.howToUserMultiThread.extendsThreadClass;

/**
 * @author mr.24
 * @version Id: MyThreadRun, v 1.0 2019-06-13 23:40 Exp $$
 */
public class MyThreadRun {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束！");
    }
}
