package com.wangwei.product.exception;

import com.wangwei.product.enums.ResultEnum;
import lombok.Data;

/**
 * @Auther wangwei
 * @Date 2018/4/9 下午4:39
 */
@Data
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
