package com.examplerabbit.rabbitmq_demo.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqProducer {

    @Value("${sr.rabbit.exchange.name}")
    private String exchange;
    @Value("${sr.rabbit.routing.name}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        log.info(String.format("Message sent -> %s" + message));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
