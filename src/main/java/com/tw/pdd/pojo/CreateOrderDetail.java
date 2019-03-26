package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateOrderDetail implements Serializable {
    private String orderNo;
    private List<CreateOrderPojo> goodsNumberAndGoodsIdList;
}
