/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.twoThreadWithSyncOnMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 使用synchronized修饰方法，避免"非线程安全"问题
 *
 * @author mr.24
 * @version Id: Test, v 1.0 2019-06-16 15:38 Exp $$
 */
@RunWith(MockitoJUnitRunner.class)
public class ThreadSafeTest {

    @Test
    public void testSafe() {
        // 只有一个实例化对象，不同线程均可以访问
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num);
        threadA.start();

        ThreadB threadB = new ThreadB(num);
        threadB.start();
    }
}
