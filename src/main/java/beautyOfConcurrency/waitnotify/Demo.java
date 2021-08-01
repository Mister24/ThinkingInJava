/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.waitnotify;

/**
 * @author mr.24
 * @version Id: Demo, v 1.0 2021/8/1 11:22 上午 Exp $$
 */
public class Demo {
    public static void main(String[] args) {
        final Demo demo = new Demo();
//        new Thread(() -> {
//            demo.waitMe();
//        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.waitMe();
            }
        });
    }

    public synchronized void waitMe() {
        System.out.println("before" + System.currentTimeMillis());
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after" + System.currentTimeMillis());
    }
}
