package com.example.application.service;

import com.example.application.assembler.OrderDtoMapper;
import com.example.common.exception.BusinessException;
import com.example.domain.entity.Order;
import com.example.domain.repository.OrderRepository;
import com.example.domain.repository.ProductRepository;
import com.example.presentation.vo.OrderDto;
import com.example.presentation.vo.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.common.exception.BaseExceptionCode.INVALID_PRODUCT;
import static com.example.common.exception.BaseExceptionCode.NO_ITEM_FOUND;

@Service
@AllArgsConstructor
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDtoMapper mapper = OrderDtoMapper.MAPPER;

    public OrderDto createOrder(OrderRequest orderDetail, String customerId) {
        if (orderDetail.hasNoItem()) {
            throw new BusinessException(NO_ITEM_FOUND, NO_ITEM_FOUND.getEnMsg());
        }
        if (containsInvalidItem(orderDetail)) {
            throw new BusinessException(INVALID_PRODUCT, INVALID_PRODUCT.getEnMsg());
        }

        Order order = orderRepository.save(mapper.toOrderDo(orderDetail, customerId));
        return mapper.toOrderDto(order);
    }

    private boolean containsInvalidItem(OrderRequest orderDetail) {
        return orderDetail.getOrderItems().stream()
                .anyMatch(orderItem -> !productRepository.findById(orderItem.getProductId()).isValid());
    }
}
