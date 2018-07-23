package com.wangwei.product.service;

import com.wangwei.product.common.DecreaseStockInput;
import com.wangwei.product.common.ProductInfoOutput;
import com.wangwei.product.dataObject.ProductInfo;
import com.wangwei.product.dto.CartDTO;

import java.util.List;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午2:22
 */
public interface ProductService {

    /**
     * 查询所有在架商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据商品ID查询商品信息
     *
     * @param productId
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productId);


    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}