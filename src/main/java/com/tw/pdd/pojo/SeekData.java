package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索页面数据
 */
@Data
public class SeekData implements Serializable {
    private List<GoodsCategory> goodsCategoryList;//分类集合
    private List<GoodsBrand> goodsBrandList;//品牌集合
}
