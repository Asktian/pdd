package com.tw.pdd.service;

import com.tw.pdd.pojo.QueryVo;
import com.tw.pdd.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsByQueryVo(QueryVo queryVo);

    Goods getGoodsAndDetails(Integer id);
}
