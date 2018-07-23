package com.wangwei.product.common;

import lombok.Data;

/**
 * @Auther wangwei
 * @Date 2018/4/10 下午1:32
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
