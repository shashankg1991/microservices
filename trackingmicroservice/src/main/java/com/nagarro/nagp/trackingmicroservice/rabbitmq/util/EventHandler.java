package com.nagarro.nagp.trackingmicroservice.rabbitmq.util;

import com.nagarro.nagp.trackingmicroservice.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
    @Autowired
    TrackingService trackingService;

    void handleEvent(String event, Object message) {
        Events eventEnumValue = Events.valueOf(event);
        trackingService.addRecord(event,message);
    }
}
