/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.shareData;

/**
 * @author mr.24
 * @version Id: UnSafeDataThread, v 1.0 2019-06-15 16:45 Exp $$
 */
public class UnSafeDataThread extends Thread {
    private int count = 5;
    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算，count = " + count);
    }
}
