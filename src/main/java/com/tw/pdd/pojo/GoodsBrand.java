package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌
 */
@Data
public class GoodsBrand implements Serializable {
    private int id;//品牌编号
    private int goodsCategoryId;//分类编号
    private String title;//品牌名称
    private String goodsBrandImg;//品牌图片
}
