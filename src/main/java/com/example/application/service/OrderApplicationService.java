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

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.common.exception.BaseExceptionCode.*;

@Service
@AllArgsConstructor
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDtoMapper mapper = OrderDtoMapper.MAPPER;

    public OrderDto createOrder(OrderRequest orderDetail, String customerId) throws BusinessException {
        if (orderDetail.hasNoItem()) {
            throw new BusinessException(NO_ITEM_FOUND, NO_ITEM_FOUND.getEnMsg());
        }
        if (containsInvalidItem(orderDetail)) {
            throw new BusinessException(INVALID_PRODUCT, INVALID_PRODUCT.getEnMsg());
        }

        if (!totalPriceMatches(orderDetail)) {
            throw new BusinessException(TOTAL_NOT_MATCH, TOTAL_NOT_MATCH.getEnMsg());
        }
        Order order = orderRepository.save(mapper.toOrderDo(orderDetail, customerId));
        return mapper.toOrderDto(order);
    }

    private boolean totalPriceMatches(OrderRequest orderDetail) {
        return orderDetail.getOrderItems().stream().map(orderItem ->
                        productRepository.findById(orderItem.getProductId()).unitPrice()
                                .multiply(new BigDecimal(orderItem.getQuantity())))
                .reduce(new BigDecimal("0.00"), BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP)
                .toString().equals(orderDetail.getTotalPrice());
    }

    private boolean containsInvalidItem(OrderRequest orderDetail) {
        return orderDetail.getOrderItems().stream()
                .anyMatch(orderItem -> !productRepository.findById(orderItem.getProductId()).isValid());
    }
}
