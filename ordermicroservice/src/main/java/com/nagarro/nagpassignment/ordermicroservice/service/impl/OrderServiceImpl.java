package com.nagarro.nagpassignment.ordermicroservice.service.impl;

import com.nagarro.nagpassignment.ordermicroservice.dao.OrderDao;
import com.nagarro.nagpassignment.ordermicroservice.entity.Order;
import com.nagarro.nagpassignment.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public void addOrder() {
        orderDao.addOrder();
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
