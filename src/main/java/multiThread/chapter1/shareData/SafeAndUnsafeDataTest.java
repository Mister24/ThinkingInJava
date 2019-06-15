/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.shareData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author mr.24
 * @version Id: SafeAndUnsafeDataTest, v 1.0 2019-06-15 16:35 Exp $$
 */
@RunWith(MockitoJUnitRunner.class)
public class SafeAndUnsafeDataTest {
    @Test
    public void testSafeData() throws InterruptedException {
        // 创建三个不同的线程变量
        SafeDataThread threadA = new SafeDataThread("a");
        SafeDataThread threadB = new SafeDataThread("b");
        SafeDataThread threadC = new SafeDataThread("c");

        threadA.start();
        Thread.sleep(3);
        threadB.start();
        threadC.start();
    }

    @Test
    public void testUnsafeData() throws InterruptedException {
        UnSafeDataThread thread = new UnSafeDataThread();

        Thread thread1 = new Thread(thread, "1");
        Thread thread2 = new Thread(thread, "2");
        Thread thread3 = new Thread(thread, "3");
        Thread thread4 = new Thread(thread, "4");
        Thread thread5 = new Thread(thread, "5");
        Thread thread6 = new Thread(thread, "6");
        Thread thread7 = new Thread(thread, "7");
        Thread thread8 = new Thread(thread, "8");
        Thread thread9 = new Thread(thread, "9");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
    }
}
