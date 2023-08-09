package com.example.domain.entity;

public enum ProductStatus {

    VALID("valid"),
    INVALID("valid");

    public final String label;

    ProductStatus(String label) {
        this.label = label;
    }
}
