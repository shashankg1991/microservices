package com.nagarro.nagpassignment.ordermicroservice.rabbitmq.service;

import com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util.EventHandler;
import com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util.Events;
import com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util.Producer;
import com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util.QueueConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

@Component
public class RabbitMQMessagingService {
    public static final String EVENT = "event";
    public static final String MESSAGE = "message";
    Producer producer;

    @Value("${rabbitmq.queue.publishing}")
    private String publishingQueue;
    @Value("${rabbitmq.queue.listening}")
    private String listeningQueue;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.host}")
    private String host;
    @Resource
    EventHandler eventHandler;

    @PostConstruct
    private void initialize() throws IOException, TimeoutException {
        //Initialize consumer
        QueueConsumer consumer = new QueueConsumer(listeningQueue, host, eventHandler);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        //Initialize Producer
        producer = new Producer(publishingQueue, host,exchange);
    }

    public void publishEvent(Events event, Object messages) {
        try {
            HashMap<String, Object> message = new HashMap<String, Object>();
            message.put(EVENT, event.name());
            message.put(MESSAGE, messages);
            producer.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
