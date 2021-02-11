package com.ruoyi.rabbit.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.rabbit.product.entity.OrderInfo;
import com.ruoyi.rabbit.product.service.FanoutProduct;
import com.ruoyi.rabbit.product.service.TopicProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    FanoutProduct fanoutProduct;

    @Autowired
    TopicProduct topicProduct;
    @GetMapping("/p")
    public String product(String msg) {
        fanoutProduct.sendMsg("大家号啊啊啊啊啊 ");
        System.out.println("发送成功");
        return "fanout广播模式成功";
    }
    @GetMapping("/topic")
    public String topicProduct(String msg) throws JsonProcessingException {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(1L);
        orderInfo.setProductCount(3000);
        String s = new ObjectMapper().writeValueAsString(orderInfo);
        topicProduct.sendTopicMsg("你好啊Topic","zhujing.topic",s);
    return "topic订阅模式成功";
    }

}
