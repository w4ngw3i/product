package com.wangwei.product.service.impl;

import com.wangwei.product.common.DecreaseStockInput;
import com.wangwei.product.common.ProductInfoOutput;
import com.wangwei.product.dataObject.ProductInfo;
import com.wangwei.product.dto.CartDTO;
import com.wangwei.product.enums.ProductStatusEnum;
import com.wangwei.product.enums.ResultEnum;
import com.wangwei.product.exception.ProductException;
import com.wangwei.product.repository.ProductInfoReopsitory;
import com.wangwei.product.service.ProductService;
import com.wangwei.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午2:24
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoReopsitory productInfoReopsitory;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoReopsitory.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productId) {
        return productInfoReopsitory.findByProductIdIn(productId);
    }


    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);

        //发送mq消息
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(e, output);
            return output;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputList));

    }


    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput: decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoReopsitory.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXISTS);
            }

            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoReopsitory.save(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }

}
