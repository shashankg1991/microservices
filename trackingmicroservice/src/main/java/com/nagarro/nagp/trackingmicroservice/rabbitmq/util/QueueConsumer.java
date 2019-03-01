package com.nagarro.nagp.trackingmicroservice.rabbitmq.util;

import com.nagarro.nagp.trackingmicroservice.rabbitmq.service.RabbitMQMessagingService;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class QueueConsumer extends Connector implements Runnable, Consumer {

    EventHandler eventHandler;

    public QueueConsumer(String queueName, String host) throws IOException, TimeoutException {
        super(queueName, host);
    }

    public QueueConsumer(String queueName, String host, EventHandler eventHandler) throws IOException, TimeoutException {
        this(queueName, host);
        this.eventHandler = eventHandler;
    }

    public void run() {
        try {
            channel.basicConsume(queueName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when consumer is registered.
     */
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer " + consumerTag + " registered");

    }

    /**
     * Called when new message is available.
     */
    public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body)
            throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(body);
        System.out.println("Event= " + map.get(RabbitMQMessagingService.EVENT) + " ,Message=" + map.get(RabbitMQMessagingService.MESSAGE) + " received.");
        System.out.println("eventHandler : " + eventHandler);
        eventHandler.handleEvent((String) map.get(RabbitMQMessagingService.EVENT), map.get(RabbitMQMessagingService.MESSAGE));
    }

    public void handleCancel(String consumerTag) {
        System.out.println("Consumer canceled---------------------------------------");
    }

    public void handleCancelOk(String consumerTag) {
    }

    public void handleRecoverOk(String consumerTag) {
    }

    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {
    }
}
