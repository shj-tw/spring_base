package com.example.presentation.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderStatus {
    CREATED("Created");

    @Getter
    private final String value;
}
