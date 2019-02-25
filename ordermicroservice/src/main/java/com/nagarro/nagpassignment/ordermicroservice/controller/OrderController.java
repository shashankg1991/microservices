package com.nagarro.nagpassignment.ordermicroservice.controller;

import com.nagarro.nagpassignment.ordermicroservice.entity.Order;
import com.nagarro.nagpassignment.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<Iterable<Order>> getAll() {
        Iterable<Order> all = orderService.getOrders();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity<Iterable<Order>> add() {
        orderService.addOrder();
        Iterable<Order> all = orderService.getOrders();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/testUpdate/{id}")
    public ResponseEntity<Iterable<Order>> update(@PathVariable(name = "id") String id) {
        orderService.updateOrderStock(Integer.parseInt(id));
        Iterable<Order> all = orderService.getOrders();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
