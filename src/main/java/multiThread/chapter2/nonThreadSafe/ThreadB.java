/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.nonThreadSafe;

import multiThread.chapter2.nonThreadSafe.HasselfPrivateNum;

/**
 * @author mr.24
 * @version Id: ThreadB, v 1.0 2019-06-16 15:37 Exp $$
 */
public class ThreadB extends Thread {
    private HasselfPrivateNum numRef;

    public ThreadB(HasselfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public synchronized void start() {
        super.start();
        numRef.add("b");
    }
}
