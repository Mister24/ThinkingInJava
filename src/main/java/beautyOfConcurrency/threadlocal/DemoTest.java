/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.threadlocal;

/**
 * @author mr.24
 * @version Id: DemoTest, v 1.0 2021/7/11 8:49 下午 Exp $$
 */
public class DemoTest {
    /**
     * ThreadLocal 父子线程值隔离
     */
    private static ThreadLocal<String> TL = new ThreadLocal<>();
    /**
     * InheritableThreadLocal 父线程值传递给子线程
     */
    private static InheritableThreadLocal<String> ITL = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        TL.set("123");
        ITL.set("234");

        System.out.println("TL in mainThread:" + TL.get());
        System.out.println("ITL in mainThread:" + ITL.get());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("TL in subThread:" + TL.get());
                System.out.println("ITL in subThread:" + ITL.get());
            }
        });

        thread.start();
        // 显式清空
        TL.remove();
        // 显式清空
        ITL.remove();
    }

}
