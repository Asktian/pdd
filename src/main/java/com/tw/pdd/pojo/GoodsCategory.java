package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 一级分类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GoodsCategory implements Serializable {
    private int id;//一级分类编号
    private String name;//一级分类名称
    private List<GoodsCategoryDetail> goodsCategoryDetails;//二级分类集合
}
