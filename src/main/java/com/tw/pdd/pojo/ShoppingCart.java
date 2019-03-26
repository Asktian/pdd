package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ShoppingCart implements Serializable {
    private int cartId;
    private String uuid;
    private int goodsId;
    private int goodsNumber;
    private double goodsPrice;
    private double goodsMoney;
    private String goodsSpec;
    private Goods goods;
}
