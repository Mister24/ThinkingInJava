/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author mr.24
 * @version Id: MyService, v 1.0 2019-06-27 00:30 Exp $$
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public void testMethod() {
        lock.lock();
        IntStream.range(0, 4).forEach(i -> System.out.println("ThreadName = " + Thread.currentThread().getName() + ", " + i));
        lock.unlock();
    }
}
