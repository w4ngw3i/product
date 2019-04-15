package com.wangwei.product.controller;

import com.wangwei.product.common.DecreaseStockInput;
import com.wangwei.product.common.ProductInfoOutput;
import com.wangwei.product.dataObject.ProductCategory;
import com.wangwei.product.dataObject.ProductInfo;
import com.wangwei.product.dto.CartDTO;
import com.wangwei.product.service.CategoryService;
import com.wangwei.product.service.ProductService;
import com.wangwei.product.utils.ResultVOUtils;
import com.wangwei.product.vo.ProductInfoVO;
import com.wangwei.product.vo.ProductVO;
import com.wangwei.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午2:19
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    /**
     *
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){

        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. 查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {

            ProductVO productVO = new ProductVO();

            productVO.setCategoryName(productCategory.getCategoryName());

            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo : productInfoList) {

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){

                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }

        return ResultVOUtils.success(productVOList);

    }

    /**
     * 获取商品列表（给订单服务用的）
     * 用@RequestBody注解请求方式必须是post
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return productService.findList(productIdList);

    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }
}
