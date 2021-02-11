package com.user.test.config.product;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ProductConfig {



    @Bean
    public Queue queue() {
    return new Queue("test1");
    }




}
