package com.examplerabbit.rabbitmq_demo.producer;

import com.examplerabbit.rabbitmq_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonRabbitMqProducer {

    @Value("${sr.rabbit.json.exchange.name}")
    private String jsonExchange;
    @Value("${sr.rabbit.json.routing.name}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public JsonRabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user){
        log.info(String.format("Json message sent -> %s" + user.toString()));
        rabbitTemplate.convertAndSend(jsonExchange,jsonRoutingKey,user);
    }
}
