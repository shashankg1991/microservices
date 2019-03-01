package com.nagarro.nagp.stockmicroservice.rabbitmq.util;

import com.nagarro.nagp.stockmicroservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
    @Autowired
    StockService stockService;

    void handleEvent(String event, Object message) {
        Events eventEnumValue = Events.valueOf(event);
        switch (eventEnumValue) {
            case ORDER_REQUEST_RECEIVED:
                stockService.reserveStockForOrder((Integer) message);
                break;
            case STOCK_UPDATE_RECIEVED:
                System.out.println("Not doing anything with STOCK_UPDATE_RECIEVED :" + message);
                break;
        }
    }
}
