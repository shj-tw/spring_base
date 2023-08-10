package com.example.presentation.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private List<OrderItemDto> orderItems;
    private String totalPrice;
}

