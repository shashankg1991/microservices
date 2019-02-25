package com.nagarro.nagpassignment.ordermicroservice.dao;

import com.nagarro.nagpassignment.ordermicroservice.entity.Order;

import java.util.List;

public interface OrderDao {
    void addOrder();

    List<Order> getOrders();

    void updateOrderStock(int id);
}
