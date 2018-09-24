/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package db.redis;

import redis.clients.jedis.Jedis;

/**
 *
 * @author fayuan.fzw
 * @version $Id: ConnectTest.java, v 0.1 2018年09月25日 上午12:11 fayuan.fzw Exp $
 */
public class ConnectTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection sucess.");

        System.out.println("服务正在运行:" + jedis.ping());
    }
}