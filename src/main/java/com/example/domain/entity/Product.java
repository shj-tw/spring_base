package com.example.domain.entity;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private String price;
    private ProductStatus status;
}
