package com.nagarro.nagp.stockmicroservice.service;

public interface StockService {
    Boolean reserveStockForOrder(int orderId);
}
