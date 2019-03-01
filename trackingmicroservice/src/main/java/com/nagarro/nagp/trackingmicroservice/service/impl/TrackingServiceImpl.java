package com.nagarro.nagp.trackingmicroservice.service.impl;

import com.nagarro.nagp.trackingmicroservice.rabbitmq.service.RabbitMQMessagingService;
import com.nagarro.nagp.trackingmicroservice.service.TrackingService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TrackingServiceImpl implements TrackingService {
    @Resource
    RabbitMQMessagingService rabbitMQMessagingService;

    @Override
    public void addRecord(String event, Object message) {
        //Dummy service
        System.out.println("Added record: " + event + " " + message);
    }
}
