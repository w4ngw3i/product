package com.wangwei.product.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * @Auther wangwei
 * @Date 2018/4/7 下午2:28
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),

    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
