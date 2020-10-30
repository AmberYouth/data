package com.yang.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        //连接redis,传递
        Jedis jedis = new Jedis("192.168.186.129",6379);
        jedis.set("k1","v1");
        String v1 = jedis.get("k1");
        System.out.println(v1);
        System.out.println(jedis.exists("k1"));
    }
}
