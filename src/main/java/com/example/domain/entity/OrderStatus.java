package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderStatus {
    CREATED("Created");

    @Getter
    private final String value;
}
