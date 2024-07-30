package com.examplerabbit.rabbitmq_demo.controller;

import com.examplerabbit.rabbitmq_demo.producer.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rabbit")
public class RabbitMqController {

    private final RabbitMqProducer rabbitMqProducer;

    public RabbitMqController(RabbitMqProducer rabbitMqProducer) {
        this.rabbitMqProducer = rabbitMqProducer;
    }

    @GetMapping("/publis")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ...");
    }
}
