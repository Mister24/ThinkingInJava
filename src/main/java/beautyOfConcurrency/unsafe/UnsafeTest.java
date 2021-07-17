/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author mr.24
 * @version Id: UnsafeTest, v 1.0 2021/7/18 12:05 上午 Exp $$
 */
public class UnsafeTest {
    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;
    static {
        try {
            // 使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            field.setAccessible(true);
            // 获取该变量的值
            unsafe = (Unsafe) field.get(null);
            // 获取state的偏移量
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }
    public static void main(String[] args) {
        UnsafeTest test = new UnsafeTest();
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
