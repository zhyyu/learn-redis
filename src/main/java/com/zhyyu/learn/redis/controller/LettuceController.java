package com.zhyyu.learn.redis.controller;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class LettuceController {

    private RedisStringCommands<String, String> sync;

    @PostConstruct
    private void init() {
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        sync = connection.sync();
    }

    @RequestMapping("setAndGet")
    public String setAndGet() {
        sync.set("mykey", "myval");
        String val = sync.get("mykey");
        System.out.println(val);
        return val;
    }


}
