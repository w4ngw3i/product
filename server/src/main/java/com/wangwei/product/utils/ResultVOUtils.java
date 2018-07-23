package com.wangwei.product.utils;

import com.wangwei.product.vo.ResultVO;

/**
 * @Auther wangwei
 * @Date 2018/4/7 下午5:10
 */
public class ResultVOUtils {

    public static ResultVO success(Object obj){

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);

        resultVO.setMsg("成功");

        resultVO.setData(obj);

        return resultVO;
    }
}
