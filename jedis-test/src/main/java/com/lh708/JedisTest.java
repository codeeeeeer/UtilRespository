package com.lh708;

import redis.clients.jedis.Jedis;

/**
 * 〈the test class of jedis〉
 *
 * @author LewJay
 * @create 2018/6/2 18:42
 */
public class JedisTest {
    public static void main(String[] args){
        Jedis jedis = new Jedis("192.168.25.130", 6379);
        jedis.set("test01", "test01");
        System.out.println(jedis.get("test01"));
    }
}
