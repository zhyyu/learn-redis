package com.zhyyu.learn.redis.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;

public class BasicUsage {

    public static void main(String[] args) {
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringCommands sync = connection.sync();
        String value = (String) sync.get("foo");
        System.out.println(value);

        sync.set("mykey", "myval");
        System.out.println(sync.get("mykey"));
    }

}
