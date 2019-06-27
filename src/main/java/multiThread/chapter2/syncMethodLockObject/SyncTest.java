/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.syncMethodLockObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author mr.24
 * @version Id: SyncTest, v 1.0 2019-06-16 22:50 Exp $$
 */
@RunWith(MockitoJUnitRunner.class)
public class SyncTest {
    @Test
    public void test() {
        MyObject object = new MyObject();

        ThreadA threadA = new ThreadA(object);
        threadA.setName("A");

        ThreadB threadB = new ThreadB(object);
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }
}
