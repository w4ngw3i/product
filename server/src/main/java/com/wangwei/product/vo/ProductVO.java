package com.wangwei.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午4:27
 */
@Data
public class ProductVO {

    @JsonProperty("name")//指定返回前端字段为name,
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
