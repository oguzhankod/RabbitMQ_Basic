package com.examplerabbit.rabbitmq_demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqListener {


    @RabbitListener(queues = {"${sr.rabbit.queue.name}"})
    public void consume(String message){
        log.info("Recieved message -> %s" + message);

    }
}
