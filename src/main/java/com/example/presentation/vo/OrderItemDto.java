package com.example.presentation.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemDto {
    private String productId;
    private String productName;
    private Integer quantity;
}
