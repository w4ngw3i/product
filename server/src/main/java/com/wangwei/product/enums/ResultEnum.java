package com.wangwei.product.enums;

import lombok.Getter;

/**
 * @Auther wangwei
 * @Date 2018/4/9 下午4:41
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXISTS(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
