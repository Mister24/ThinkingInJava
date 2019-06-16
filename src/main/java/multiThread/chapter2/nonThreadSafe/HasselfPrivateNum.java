/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package multiThread.chapter2.nonThreadSafe;

/**
 * @author mr.24
 * @version Id: HasselfPrivateNum, v 1.0 2019-06-16 15:50 Exp $$
 */
public class HasselfPrivateNum {
    private int num = 0;

    /**
     * add methed <tt>username</tt>.
     *
     * @param username 用户名
     */
    public void add(String username) {
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over!");
        } else {
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(username + " num = " + num);
    }
}
