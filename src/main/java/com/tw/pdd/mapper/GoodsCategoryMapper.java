package com.tw.pdd.mapper;

import com.tw.pdd.pojo.GoodsBrand;
import com.tw.pdd.pojo.GoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {
    List<Object> getGoodsCategoryList();
    List<GoodsCategory> getGoodsCategoryAndGoodsCategoryDetail();
    List<GoodsBrand> getGoodsBrandList();
}
