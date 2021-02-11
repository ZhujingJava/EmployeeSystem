package com.ruoyi.rabbit.product.service;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutProduct {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {
//        rabbitTemplate.convertAndSend("exchange", "", msg);

    }

}
