package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Goods implements Serializable {
    private int goodsId;//商品编号
    private int goodsCategoryDetailId;//商品二级分类编号
    private String goodsName;//商品名称
    private String shortName;//商品短名称
    private String imageUrl;//商品图片
    private String thumbUrl;//商品图片
    private String hdThumbUrl;//商品图片
    private float price;//商品价格(封面)
    private String num;//团购数量
    private List<OrderDetail> orderDetailList;
    private GoodsDetails goodsDetails;//商品详情集合
}
