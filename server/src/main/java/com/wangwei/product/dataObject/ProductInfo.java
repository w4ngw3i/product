package com.wangwei.product.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther wangwei
 * @Date 2018/4/7 上午11:00
 */
@Data
//@Table(name="表名")如果类名和表名不一致使用
@Entity
public class ProductInfo {
    /**
     * 产品ID
     */
    @Id
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 图片
     */
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    private Integer productStatus;

    /**
     * '类目编号'
     */
    private Integer categoryType;

    /**
     * '创建时间'
     */
    private Date createTime;

    /**
     * '更新时间'
     */
    private Date updateTime;
}
