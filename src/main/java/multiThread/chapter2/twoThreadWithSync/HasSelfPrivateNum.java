/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.twoThreadWithSync;

/**
 * 使用synchronized关键字修饰方法
 *
 * @author mr.24
 * @version Id: HasSelfPrivateNum, v 1.0 2019-06-16 21:26 Exp $$
 */
public class HasSelfPrivateNum {
    private int num = 0;
    synchronized public void add(String username) {
        int num = 0;
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over!");
        } else {
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(username + "num = " + num);
    }
}
