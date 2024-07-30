package com.examplerabbit.rabbitmq_demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonRabbitMqConfig {

    @Value("${sr.rabbit.json.queue.name}")
    private String jsonQueue;
    @Value("${sr.rabbit.json.exchange.name}")
    private String jsonExchange;
    @Value("${sr.rabbit.json.routing.name}")
    private String jsonRoutingKey;

    @Bean
    public Queue jsonQueue(){
        return new Queue(jsonQueue);
    }

    @Bean
    public TopicExchange jsonExchange(){
        return new TopicExchange(jsonExchange);
    }

    @Bean
    public Binding jsonBinding(){
        return BindingBuilder.bind(jsonQueue())
                .to(jsonExchange())
                .with(jsonRoutingKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
