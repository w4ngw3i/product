package com.wangwei.product.repository;

import com.wangwei.product.common.ProductInfoOutput;
import com.wangwei.product.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther wangwei
 * @Date 2018/4/7 上午11:13
 */
public interface ProductInfoReopsitory extends JpaRepository<ProductInfo, String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfoOutput> findByProductIdIn(List<String> productId);
}
