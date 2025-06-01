package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.util.OrderCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderCodeGenerator codeGenerator;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderCodeGenerator codeGenerator) {
        this.orderRepository = orderRepository;
        this.codeGenerator = codeGenerator;
    }

    @Override
    public Order createOrder(String name, String description, String codeGenerationStrategy) {
        String code = switch (codeGenerationStrategy.toLowerCase()) {
            case "random" -> codeGenerator.generateRandomCode();
            case "random_with_date" -> codeGenerator.generateRandomCodeWithDate();
            case "prefixed_suffixed" -> codeGenerator.generatePrefixedSuffixedCode();
            default -> throw new IllegalArgumentException("Unknown strategy: " + codeGenerationStrategy);
        };

        Order order = new Order(code, name, description);
        return orderRepository.save(order);
    }

    @Override
    public Order findOrderByCode(String code) {
        return orderRepository.findById(code).orElse(null);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(String code) {
        orderRepository.deleteById(code);
    }
}