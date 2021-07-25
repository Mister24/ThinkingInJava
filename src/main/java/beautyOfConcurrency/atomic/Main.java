/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author mr.24
 * @version Id: Main, v 1.0 2021/7/26 12:39 上午 Exp $$
 */
public class Main {
    private static AtomicLong atomicLong = new AtomicLong();

    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,1};
    private static Integer[] arrayTwo = new Integer[]{0,0,0,3,0,1};
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < arrayOne.length; i++) {
                if (arrayOne[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
             }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < arrayTwo.length; i++) {
                if (arrayTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadOne.join();

        System.out.println("count 0:" + atomicLong.get());
    }
}
