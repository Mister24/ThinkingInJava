/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package db.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 验证redis的5中基本类型：String、List、Hash、Set、有序Set。
 *
 * @author fayuan.fzw
 * @version $Id: Redis.java, v 0.1 2018年09月25日 上午12:11 fayuan.fzw Exp $
 */
public class Redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection sucess.");

        System.out.println("服务正在运行:" + jedis.ping());
    }

    @Test
    public void stringSetAndGet() {
        Jedis jedis = new Jedis("localhost");

        //存
        jedis.set("city", "sh");

        System.out.println(jedis.get("city"));
        //追加
        System.out.println(jedis.get("-----------"));
        jedis.append("city", "bj");
        System.out.println(jedis.get("city"));
    }

    @Test
    public void listSetAndGet() {
        Jedis jedis = new Jedis("localhost");

        jedis.del("cities");
        //存，新来的在list头位置，[hz, bj, sh]
        jedis.lpush("cities", "sh");
        jedis.lpush("cities", "bj");
        jedis.lpush("cities", "hz");

        //将新的数据存储在list的头位置，[hk, hz, bj, sh]
        jedis.lpushx("cities", "hk");

        jedis.rpush("cities", "nj");
        jedis.rpush("cities", "tj");

        //取，参数1表示key，参数2表示起始位置，参数3表示结束位置
        List<String> cities = jedis.lrange("cities", 0, 10);
        System.out.println(cities.size());
        System.out.println("------------");
        System.out.println(jedis.lrange("cities", 0, -1));
        System.out.println("------------");
        System.out.println(jedis.lrange("cities", 0, -2));
    }

    @Test
    public void mapSetAndGet() {
        Jedis jedis = new Jedis("localhost");

        Map<String, String> map = new HashMap<>();

        //存
        map.put("name", "kobe");
        map.put("no", "24");
        map.put("sex", "man");

        jedis.hmset("player", map);

        String[] player = new String[map.size()];
        player[0] = "name";
        player[1] = "no";
        player[2] = "sex";

        //取
        List<String> list = jedis.hmget("player", player);
        for (int i = 0; i < player.length; i++) {
            System.out.println("键值对：" + player[i] + ":" + list.get(i));
        }
    }

    @Test
    public void setSetAndGet() {
        Jedis jedis = new Jedis("localhost");

        jedis.del("set");
        jedis.sadd("set", "a");
        jedis.sadd("set", "b");
        jedis.sadd("set", "c");

        Set<String> keys = jedis.smembers("set");

        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    /**
     * zset
     *
     * 不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
     *
     * */
    public void sortedSetsetAndGet() {
        Jedis jedis = new Jedis("localhost");

        jedis.zadd("country", 0, "China");
        jedis.zadd("country", 1.0, "USA");
        jedis.zadd("country", 1, "Germany");
        jedis.zadd("country", 2, "Russia");

        System.out.println(jedis.zcard("country"));

        System.out.println(jedis.zrevrangeByScore("country", 5, 0));

        System.out.println("----------------");

        jedis.zrem("country", "Germany");
        jedis.zremrangeByScore("country", 1, 1.1);
        System.out.println(jedis.zrevrangeByScore("country", 5, 0));
    }

    @Test
    public void hashSetAndGet() {
        Jedis jedis = new Jedis("localhost");

        jedis.hset("hash", "key1", "value1");
        jedis.hset("hash", "key2", "value2");
        jedis.hset("hash", "key3", "value3");

        jedis.hincrBy("hash", "key4", 1);
        System.out.println(jedis.hvals("hash"));

        System.out.println("------------------");
        jedis.hdel("hash", "key1");
        System.out.println(jedis.hvals("hash"));

        System.out.println("------------------");
        jedis.hincrBy("hash", "key4", 2);
        System.out.println(jedis.hvals("hash"));



    }


}