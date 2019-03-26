package com.tw.pdd.pojo;

import lombok.Data;

/**
 * 创建订单用于集合的实体类
 */
@Data
public class CreateOrderPojo {
    private int goodsId;//商品ID
    private int goodsNumber;//商品数量
    private String goodsSpec;//商品规格

    public CreateOrderPojo() {
        super();
    }

    public CreateOrderPojo(int goodsId, int goodsNumber, String goodsSpec) {
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.goodsSpec = goodsSpec;
    }
}
