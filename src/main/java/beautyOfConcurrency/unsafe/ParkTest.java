/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 阻塞线程
 *
 * @author mr.24
 * @version Id: ParkTest, v 1.0 2021/7/19 12:02 上午 Exp $$
 */
public class ParkTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        MyThread myThread = new MyThread(Thread.currentThread(), unsafe);
        myThread.start();

        // 阻塞线程
        unsafe.park(false, 0L);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ", i =" + i);
        }
        unsafe.unpark(myThread);
    }

    static class MyThread extends Thread {
        public Thread parent = null;
        public Unsafe unsafe = null;

        public MyThread(Thread parent, Unsafe unsafe) {
            super();
            this.parent = parent;
            this.unsafe = unsafe;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    // i = 5时，唤醒父线程，阻塞子线程
                    unsafe.unpark(parent);
                    unsafe.park(false, 0L);
                }
                System.out.println(Thread.currentThread().getName() + ", i=" + i);
            }
        }
    }
}
