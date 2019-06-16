/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.shareData;

/**
 * @author mr.24
 * @version Id: SafeDataThread, v 1.0 2019-06-15 16:32 Exp $$
 */
public class SafeDataThread extends Thread {
    private int count = 5;

    public SafeDataThread(String name) {
        super();
        // 设置线程名称
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算，count = " + count);
        }
    }
}
