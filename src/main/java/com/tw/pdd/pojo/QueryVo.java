package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询
 */
@Data
public class QueryVo implements Serializable {
    private Integer goodsId;//商品编号
    private Integer goodsCategoryDetailId;//二级分类编号
    private String goodsName;//商品名称
    private String uuid;//用户编号
    private String userPhone;//用户手机号码
}
