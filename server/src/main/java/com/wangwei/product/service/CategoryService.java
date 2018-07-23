package com.wangwei.product.service;

import com.wangwei.product.dataObject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午2:43
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
