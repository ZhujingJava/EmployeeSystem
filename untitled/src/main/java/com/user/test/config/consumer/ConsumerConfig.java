package com.user.test.config.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test1"), exchange = @Exchange(value = "exchange", type = ExchangeTypes.FANOUT)))
public class ConsumerConfig {

    @RabbitHandler()

    public void receive(Object o) {
        System.out.println("fanout" + o);

    }
}
