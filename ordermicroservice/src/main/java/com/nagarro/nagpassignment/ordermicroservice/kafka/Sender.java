package com.nagarro.nagpassignment.ordermicroservice.kafka;

import com.nagarro.nagpassignment.ordermicroservice.OrderRequestReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    @Autowired
    private KafkaTemplate<String, OrderRequestReceivedEvent> kafkaTemplate;

    public void send(String topic, OrderRequestReceivedEvent payload) {
        kafkaTemplate.send(topic, payload);
    }
}
