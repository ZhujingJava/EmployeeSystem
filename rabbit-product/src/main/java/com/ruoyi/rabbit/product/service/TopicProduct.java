package com.ruoyi.rabbit.product.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TopicProduct implements RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {
    String exchange = "topicExchange";
    @Autowired
    RabbitTemplate rabbitTemplate;

    public <T> void sendTopicMsg(String msg, String routeKey, T t) {
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback((correlationData, b, s) -> {
            System.out.println("aaaaaa" );
            if (b) {
                if (null != correlationData) {
                    correlationData.setId(String.valueOf(UUID.randomUUID()));

                }
                System.out.println("ack显示发送消息成功");
//                System.out.println(correlationData.getId());
                System.out.println(correlationData.getReturnedMessage());
            } else {
                System.out.println("ack显示消息发送失败。");
            }


        });
        rabbitTemplate.convertAndSend(exchange, routeKey, t);
        System.out.println("成功发送Topic信息");
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString() + "===" + i + "===" + s1 + "===" + s2);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("confirm" );
        if (b) {
            if (null != correlationData) {
                correlationData.setId(String.valueOf(UUID.randomUUID()));

            }
            System.out.println("ack显示发送消息成功confirm");
//                System.out.println(correlationData.getId());
            System.out.println(correlationData.getReturnedMessage());
        } else {
            System.out.println("ack显示消息发送失败。confirm");
        }
    }
}
