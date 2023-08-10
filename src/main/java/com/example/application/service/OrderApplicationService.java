package com.example.application.service;

import com.example.application.assembler.OrderDtoMapper;
import com.example.domain.entity.Order;
import com.example.domain.repository.OrderRepository;
import com.example.presentation.vo.OrderDto;
import com.example.presentation.vo.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final OrderDtoMapper mapper = OrderDtoMapper.MAPPER;

    public OrderDto createOrder(OrderRequest orderDetail, String customerId) {
        Order order = orderRepository.save(mapper.toOrderDo(orderDetail, customerId));
        return mapper.toOrderDto(order);
    }
}
