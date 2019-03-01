package com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util;

import com.nagarro.nagpassignment.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
    @Autowired
    OrderService orderService;

    void handleEvent(String event, Object message) {
        Events eventEnumValue = Events.valueOf(event);
        switch (eventEnumValue) {
            case ORDER_REQUEST_RECEIVED:
                System.out.println("Not doing anything with ORDER_REQUEST_RECEIVED :" + message);
                break;
            case STOCK_UPDATE_RECIEVED:
                orderService.updateOrderStock((int) message);
                break;
        }
    }
}
