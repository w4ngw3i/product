package com.wangwei.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther wangwei
 * @Date 2018/4/8 上午10:21
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "商品服务调用成功！ -----> 2";
    }
}
