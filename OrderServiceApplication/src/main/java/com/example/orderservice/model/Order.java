package com.example.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    // Конструкторы, геттеры и сеттеры
    public Order() {}

    public Order(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    // Геттеры и сеттеры
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Order{code='" + code + "', name='" + name + "', description='" + description + "'}";
    }
}