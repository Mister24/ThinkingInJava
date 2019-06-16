/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.nonThreadSafe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 线程不安全问题
 *
 * @author mr.24
 * @version Id: Test, v 1.0 2019-06-16 15:38 Exp $$
 */
@RunWith(MockitoJUnitRunner.class)
public class ThreadNoneSafeTest {

    @Test
    public void testSafe() {
        HasselfPrivateNum num = new HasselfPrivateNum();
        //HasselfPrivateNum numRef = new HasselfPrivateNum();

        // 两个线程同时操作同一个对象中的实例变量，可能会出现"非线程安全"问题
        ThreadA threadA = new ThreadA(num);
        threadA.start();

        ThreadB threadB = new ThreadB(num);
        threadB.start();
    }
}
