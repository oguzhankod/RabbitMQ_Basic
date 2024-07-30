package com.examplerabbit.rabbitmq_demo.controller;

import com.examplerabbit.rabbitmq_demo.model.User;
import com.examplerabbit.rabbitmq_demo.producer.JsonRabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/rabbit/json")
public class JsonRabbitMqController {

    private final JsonRabbitMqProducer jsonRabbitMqProducer;

    public JsonRabbitMqController(JsonRabbitMqProducer jsonRabbitMqProducer) {
        this.jsonRabbitMqProducer = jsonRabbitMqProducer;
    }


    @PostMapping("/publis")
    public ResponseEntity<String> publishJsonMessage(@RequestBody User user){
        jsonRabbitMqProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ...");
    }
}
