/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.threadlocal;

/**
 *
 * @author mr.24
 * @version Id: Test, v 1.0 2021/7/10 3:14 下午 Exp $$
 */
public class Test {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread1 value");
                printAndRemove("thread1");
                System.out.println("after remove, value=" + localVariable.get());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread2 value");
                printAndRemove("thread2");
                System.out.println("after remove, value=" + localVariable.get());
            }
        });

        thread1.start();
        thread2.start();
    }

    static void printAndRemove(String str) {
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }
}

