package com.nagarro.nagpassignment.ordermicroservice.service;

import com.nagarro.nagpassignment.ordermicroservice.entity.Order;

import java.util.List;

public interface OrderService {
    public void addOrder();

    public List<Order> getOrders();

    public void updateOrderStock(int id);
}
