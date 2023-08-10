package com.example.domain.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItem {
    private String id;
    private String productId;
    private String orderId;
    private Integer quantity;
}