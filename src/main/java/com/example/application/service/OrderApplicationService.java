package com.example.application.service;

import com.example.domain.entity.Order;
import com.example.domain.entity.OrderItem;
import com.example.domain.repository.OrderRepository;
import com.example.presentation.vo.OrderDto;
import com.example.presentation.vo.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    public OrderDto createOrder(OrderRequest orderDetail, String customerId) {
        return null;
    }
}
