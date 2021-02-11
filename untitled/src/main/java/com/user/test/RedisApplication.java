package com.user.test;

import com.user.test.lambda.LambdaService;
import com.user.test.lambda.impl.LambdaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
//        System.out.println(7 >> 1 << 1);
//     LambdaService as=(s)-> System.out.println(s);
        SpringApplication.run(RedisApplication.class);

    }
}
