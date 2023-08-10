package com.example.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Data
public class Product {
    private String id;
    private String name;
    private String price;
    private ProductStatus status;

    public boolean isValid() {
        return this.status.equals(ProductStatus.VALID) && Objects.nonNull(price);
    }

    public BigDecimal unitPrice() {
        return new BigDecimal(this.price).setScale(2, RoundingMode.HALF_UP);
    }

}
