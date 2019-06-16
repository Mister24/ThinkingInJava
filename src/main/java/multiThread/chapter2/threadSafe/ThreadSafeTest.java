/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.threadSafe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 方法内变量不存在"线程不安全问题"
 *
 * @author mr.24
 * @version Id: Test, v 1.0 2019-06-16 15:38 Exp $$
 */
@RunWith(MockitoJUnitRunner.class)
public class ThreadSafeTest {

    @Test
    public void testSafe() {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num);
        threadA.start();

        ThreadB threadB = new ThreadB(num);
        threadB.start();
    }
}
