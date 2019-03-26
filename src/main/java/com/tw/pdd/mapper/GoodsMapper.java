package com.tw.pdd.mapper;

import com.tw.pdd.pojo.Goods;
import com.tw.pdd.pojo.QueryVo;

import java.util.List;

public interface GoodsMapper {
    List<Goods> getGoodsByQueryVo(QueryVo queryVo);

    Goods getGoodsAndDetails(Integer id);
}
