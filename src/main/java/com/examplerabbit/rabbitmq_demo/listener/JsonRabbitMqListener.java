package com.examplerabbit.rabbitmq_demo.listener;

import com.examplerabbit.rabbitmq_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonRabbitMqListener {


    @RabbitListener(queues = {"${sr.rabbit.json.queue.name}"})
    public void consume(User user){
        log.info(String.format("Recieved json message from jsonqueue -> %s" + user.toString()));
    }
}
