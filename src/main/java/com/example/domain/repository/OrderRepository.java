package com.example.domain.repository;

import com.example.domain.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
