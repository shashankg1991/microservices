package com.nagarro.nagpassignment.ordermicroservice.dao.impl;

import com.nagarro.nagpassignment.ordermicroservice.dao.OrderDao;
import com.nagarro.nagpassignment.ordermicroservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao{
    List<Order> currentOrders = new ArrayList();

    @Override
    public void addOrder() {
        Order order = new Order();
        order.setId(currentOrders.size() + 1);
        order.setStatus("STOCK_PENDING");
    }

    @Override
    public List<Order> getOrders() {
        return currentOrders;
    }

    @Override
    public void updateOrderStock(int id) {
        for (Order order : currentOrders) {
            if (order.getId() == id) {
                order.setStatus("STOCK_CONFIRMED");
            }
        }
    }
}
