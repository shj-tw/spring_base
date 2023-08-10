package com.example.common.exception;

import lombok.Getter;

@Getter
public enum BaseExceptionCode implements IExceptionCode {
  NOT_FOUND_CUSTOMER("Not found customer."),
  NOT_FOUND_PRODUCT("Not found product."),
  INVALID_PRODUCT("Product is invalid."),
  NO_ITEM_FOUND("No Item Found.");

  BaseExceptionCode(String enMsg) {
    this.enMsg = enMsg;
  }

  String enMsg;

  @Override
  public String getValue() {
    return this.name();
  }

  @Override
  public String getLangMessage() {
    return IExceptionCode.super.getLangMessage();
  }
}
