package com.wangwei.product.vo;

import lombok.Data;

/**
 * http请求返回最外层对象
 * @Auther wangwei
 * @Date 2018/4/7 下午4:23
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
