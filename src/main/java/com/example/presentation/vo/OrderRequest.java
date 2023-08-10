package com.example.presentation.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class OrderRequest {
    private List<OrderItemDto> orderItems;
    private String totalPrice;

    public boolean hasNoItem() {
        return Objects.isNull(orderItems) || orderItems.isEmpty();
    }
}

