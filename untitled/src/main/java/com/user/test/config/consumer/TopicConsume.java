package com.user.test.config.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import com.user.test.entity.OrderInfo;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test1"), key = "*.topic", exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC)))
public class TopicConsume {
    @RabbitHandler
    public void receiveTopic(Object msg, Message message, Channel channel) throws IOException {
        if (msg.getClass()== OrderInfo.class)
            System.out.println("消息有问题");

          channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        System.out.println("topic主题订阅模式成功收到信息："+message.getMessageProperties().getReceivedUserId()+":"+message.getMessageProperties().getAppId()+":" + msg);

    }
}
