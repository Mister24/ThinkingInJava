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
    public static InheritableThreadLocal<String> ITL = new InheritableThreadLocal<>();
    public static void main(String[] args) {

        ThreadLocal<String> TL = new ThreadLocal<>();
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
        TL.remove();
        ITL.remove();
    }

}
