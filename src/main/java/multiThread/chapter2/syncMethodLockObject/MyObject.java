/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package multiThread.chapter2.syncMethodLockObject;

/**
 * @author mr.24
 * @version Id: HttpClientDemo, v 1.0 2019/6/16 下午10:46 Exp $$
 */
public class MyObject {
	synchronized public void methodA() {
		System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
		// Thread.sleep(5000);
		System.out.println("end");
	}
}