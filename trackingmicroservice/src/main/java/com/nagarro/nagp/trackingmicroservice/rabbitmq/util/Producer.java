package com.nagarro.nagp.trackingmicroservice.rabbitmq.util;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Producer extends Connector {
    public Producer(String queueName, String host) throws IOException, TimeoutException {
        super(queueName, host);
    }

    public void sendMessage(Serializable object) throws IOException {
        System.out.println("Sending message:" + object + " to queue:" + queueName);
        channel.basicPublish("", queueName, null, SerializationUtils.serialize(object));
    }
}