package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品属性
 */
@Data
public class Attribute implements Serializable {
    private String type;//属性类型
    private String name;//属性值
}
