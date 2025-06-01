package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import java.util.List;

public interface OrderService {
    Order createOrder(String name, String description, String codeGenerationStrategy);
    Order findOrderByCode(String code);
    List<Order> findAllOrders();
    void deleteOrder(String code);
}