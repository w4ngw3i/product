package com.wangwei.product.service;

import com.wangwei.product.ProductApplicationTest;
import com.wangwei.product.common.ProductInfoOutput;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;



public class ProductServiceTest extends ProductApplicationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findlist(){
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));

        Assert.assertTrue(list.size()>0);
    }

}