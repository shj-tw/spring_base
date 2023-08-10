package com.example.domain.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> orderItems;
    private String totalPrice;
    private OrderStatus status;
    private LocalDateTime createTime;
}
