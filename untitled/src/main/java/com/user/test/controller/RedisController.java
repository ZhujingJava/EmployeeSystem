package com.user.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Calendar;

@RestController

public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/")
    public void test() {
//        LocalDate localDate = new LocalDate();
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getWeekYear());
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear() + ":" + localDate.getMonthValue() + ":" + localDate.getDayOfMonth() + ":" + localDate.getDayOfYear());
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 1, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 2, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 3, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 6, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 7, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 8, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 9, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 10, true));
        redisTemplate.execute((RedisCallback) con -> con.setBit("1:year".getBytes(), 11, true));
        System.out.println(localDate.withMonth(7).getMonth());
//        Object execute = redisTemplate.execute((RedisCallback) con -> con.bitField("1:year".getBytes(), 7, 0));
//        System.out.println(execute);
        System.out.println(Integer.toBinaryString(7>>1<<1));
//        redisTemplate.opsForValue()
    }
}
