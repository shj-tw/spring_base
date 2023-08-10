package com.example.infrastructure.persistence.repository.domain;

import com.example.domain.entity.Order;
import com.example.domain.repository.OrderRepository;
import com.example.infrastructure.persistence.assembler.OrderDataMapper;
import com.example.infrastructure.persistence.entity.OrderItemPo;
import com.example.infrastructure.persistence.entity.OrderPo;
import com.example.infrastructure.persistence.repository.JpaOrderItemRepository;
import com.example.infrastructure.persistence.repository.JpaOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderDomainRepository implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;
    private final JpaOrderItemRepository jpaOrderItemRepository;
    private final OrderDataMapper mapper = OrderDataMapper.mapper;

    @Override
    public Order save(Order order) {
        OrderPo savedOrder = jpaOrderRepository.save(mapper.toOrderPo(order));
        List<OrderItemPo> orderItemPos = jpaOrderItemRepository.saveAll(mapper.toOrderItems(order.getOrderItems()));

        return mapper.toOrderDo(savedOrder, orderItemPos);
    }
}
