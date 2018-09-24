/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package db.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void stringSetAndGet() {
        Jedis jedis = new Jedis("localhost");
        jedis.set("city", "shanghai");

        String city = jedis.get("city");
        System.out.println("验证String类型变量存储结果：" + city);
    }

    @Test
    public void listSetAndGet() {
        Jedis jedis = new Jedis("localhost");
        jedis.lpush("cities", "sh");
        jedis.lpush("cities", "bj");
        jedis.lpush("cities", "hz");

        List<String> cities = jedis.lrange("cities", 0, 10);
        System.out.println(cities.size());

        for (String str : cities) {
            System.out.println(str);
        }
    }

    @Test
    public void mapSetAndGet() {
        Jedis jedis = new Jedis("localhost");

        Map<String, String> map = new HashMap<>();

        map.put("name", "kobe");
        map.put("no", "24");
        map.put("sex", "man");

        jedis.hmset("player", map);

        String[] player = new String[map.size()];
        player[0] = "name";
        player[1] = "no";
        player[2] = "sex";

        List<String> list = jedis.hmget("player", player);
        for (int i = 0; i < player.length; i++) {
            System.out.println("键值对：" + player[i] + ":" + list.get(i));
        }

    }

}