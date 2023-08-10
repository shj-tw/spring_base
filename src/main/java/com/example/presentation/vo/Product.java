package com.example.presentation.vo;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private String productId;
    private String productName;
    private Integer quantity;
}
