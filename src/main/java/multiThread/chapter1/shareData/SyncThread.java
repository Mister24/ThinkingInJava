/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter1.shareData;

/**
 * @author mr.24
 * @version Id: SyncThread, v 1.0 2019-06-15 22:12 Exp $$
 */
public class SyncThread extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算，count = " + count);
    }
}
