package com.wangwei.product.repository;

import com.wangwei.product.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoReopsitoryTest {

    @Autowired
    private ProductInfoReopsitory productInfoReopsitory;

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> list = productInfoReopsitory.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(list.size() > 0);
    }


}