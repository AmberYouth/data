package com.yang.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TransactionTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.186.129",6379);
        Transaction transaction = jedis.multi();
        transaction.set("k7","v7");
        transaction.set("k8","v8");
        transaction.exec();
    }
}
