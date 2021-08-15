/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mr.24
 * @version Id: Demo, v 1.0 2021/8/15 11:02 下午 Exp $$
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        Thread thread1 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(list.size());
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Thread thread2 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(list.size());
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Thread thread3 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(list.size());
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(2000);
        list.add(4);
    }

}
