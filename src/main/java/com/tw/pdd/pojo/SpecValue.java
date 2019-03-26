package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 规格值
 */
@Data
public class SpecValue implements Serializable {
    private int keyId;//规格键编号
    private int goodsId;//商品编号
    private String value;//值
    private List<Value> valueList;//值集合
}
