package com.nagarro.nagp.stockmicroservice.service.impl;

import com.nagarro.nagp.stockmicroservice.rabbitmq.service.RabbitMQMessagingService;
import com.nagarro.nagp.stockmicroservice.rabbitmq.util.Events;
import com.nagarro.nagp.stockmicroservice.service.StockService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StockServiceImpl implements StockService {
    @Resource
    RabbitMQMessagingService rabbitMQMessagingService;

    @Override
    public Boolean reserveStockForOrder(int orderId) {
        //Only dummy implementation
        System.out.println("Stock level reserve recieved for order : "+orderId);
        rabbitMQMessagingService.publishEvent(Events.STOCK_UPDATE_RECIEVED, orderId);
        return true;
    }
}
