package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单详情
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrderDetail implements Serializable {
    private int orderDetailId;
    private String orderNo;//订单编号
    private int goodsNumber;
    private Goods goods;//商品
    private String goodsSpec;//商品规格
}
