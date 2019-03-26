package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品详情
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GoodsDetails implements Serializable {
    private int id;//详情编号
    private int goods_id;//商品编号
    private String attribute;//商品属性
    private String introduce;//商品介绍
    private List<SpecKey> specKeyList;//商品规格集合
    private String imagesDetail;//商品详情头部图片
    private String imagesDetail2;//商品详情图片
    private List<Attribute> attributeList;//商品属性集合
    private List<Img> imagesDetailList;//商品详情头部图片集合
    private List<Img> imagesDetailList2;//商品详情图片集合
}
