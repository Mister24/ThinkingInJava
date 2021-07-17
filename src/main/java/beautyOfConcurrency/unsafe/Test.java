/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.unsafe;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.misc.Unsafe;

/**
 * @author mr.24
 * @version Id: Test, v 1.0 2021/7/17 10:47 上午 Exp $$
 */
public class Test {

    static final Unsafe unsafe = Unsafe.getUnsafe();
    static long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(Test.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private volatile long state = 0;

    public static void main(String[] args) {
        Test test = new Test();
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
