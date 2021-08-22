/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author mr.24
 * @version Id: Demo, v 1.0 2021/8/22 5:34 下午 Exp $$
 */
public class ParkDemo {
    public static void main(String[] args) {
        System.out.println("begin park");
        LockSupport.park();
        System.out.println("end park");
    }
}
