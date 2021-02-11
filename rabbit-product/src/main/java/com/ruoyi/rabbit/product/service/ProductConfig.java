package com.ruoyi.rabbit.product.service;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public Queue queue1() {
        return new Queue("test1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("test2");
    }

    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")

    private int port;
    @Value("${spring.rabbitmq.username}")

    private String userName;
    @Value("${spring.rabbitmq.password}")

    private String password;


    @Bean
    public CachingConnectionFactory rabbitConnectionFactoryBean() {
        CachingConnectionFactory rabbitConnectionFactoryBean = new CachingConnectionFactory();
        rabbitConnectionFactoryBean.setHost(host);
        rabbitConnectionFactoryBean.setPort(port);
        rabbitConnectionFactoryBean.setUsername(userName);
        rabbitConnectionFactoryBean.setPassword(password);
        return rabbitConnectionFactoryBean;

    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(rabbitConnectionFactoryBean());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(rabbitConnectionFactoryBean());
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(rabbitConnectionFactoryBean());
        simpleRabbitListenerContainerFactory.setConcurrentConsumers(10);
        simpleRabbitListenerContainerFactory.setReceiveTimeout(5000L);
        simpleRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleRabbitListenerContainerFactory;

    }
}
