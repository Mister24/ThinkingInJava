/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.nonThreadSafe;

/**
 * @author mr.24
 * @version Id: ThreadA, v 1.0 2019-06-16 15:35 Exp $$
 */
public class ThreadA extends Thread {
    private HasselfPrivateNum numRef;

    public ThreadA(HasselfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.add("a");
    }
}
