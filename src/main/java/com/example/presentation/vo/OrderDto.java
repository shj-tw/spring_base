package com.example.presentation.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String id;
    private String orderPrice;
    private OrderStatus orderStatus;
//    private List<Product> products;

}


