package com.nagarro.nagpassignment.ordermicroservice.service.impl;

import com.nagarro.nagpassignment.ordermicroservice.dao.OrderDao;
import com.nagarro.nagpassignment.ordermicroservice.entity.Order;
import com.nagarro.nagpassignment.ordermicroservice.rabbitmq.service.RabbitMQMessagingService;
import com.nagarro.nagpassignment.ordermicroservice.rabbitmq.util.Events;
import com.nagarro.nagpassignment.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    RabbitMQMessagingService rabbitMQMessagingService;

    @Override
    public void addOrder() {
        int orderId = orderDao.addOrder();
        rabbitMQMessagingService.publishEvent(Events.ORDER_REQUEST_RECEIVED, Integer.valueOf(orderId));
    }

    @Override
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public void updateOrderStock(int id) {
        orderDao.updateOrderStock(id);
    }
}
