package com.tw.pdd.service;

import com.tw.pdd.pojo.SeekData;

import java.util.List;

public interface GoodsCategoryService {
    List<Object> getGoodsCategoryList();

    SeekData getSeekData();
}
