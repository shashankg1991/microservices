package com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Producer extends Connector {
    String exchange;

    public Producer(String queueName, String host, String exchange) throws IOException, TimeoutException {
        super(queueName, host);
        this.exchange = exchange;
    }

    public void sendMessage(Serializable object) throws IOException {
        System.out.println("Sending message:" + object + " to queue:" + queueName);
        channel.basicPublish(exchange, queueName, null, SerializationUtils.serialize(object));
    }
}