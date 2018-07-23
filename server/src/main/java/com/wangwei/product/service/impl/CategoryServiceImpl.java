package com.wangwei.product.service.impl;

import com.wangwei.product.dataObject.ProductCategory;
import com.wangwei.product.repository.ProductCategoryRepository;
import com.wangwei.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午2:45
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {

        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
