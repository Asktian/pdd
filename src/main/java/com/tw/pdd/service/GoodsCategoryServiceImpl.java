package com.tw.pdd.service;

import com.tw.pdd.common.RedisCacheManager;
import com.tw.pdd.mapper.GoodsCategoryMapper;
import com.tw.pdd.pojo.GoodsBrand;
import com.tw.pdd.pojo.GoodsCategory;
import com.tw.pdd.pojo.SeekData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 获取商品一级分类
     *
     * @return
     */
    @Override
    public List<Object> getGoodsCategoryList() {
        if (redisCacheManager.hasKey("getGoodsCategoryList")) {
            return redisCacheManager.lGet("getGoodsCategoryList", 0, -1);
        } else {
            List<Object> goodsCategoryList = goodsCategoryMapper.getGoodsCategoryList();
            redisCacheManager.lSet("getGoodsCategoryList", goodsCategoryList, 3600);
            return goodsCategoryList;
        }

    }

    /**
     * 搜索板块的数据
     *
     * @return
     */
    @Override
    public SeekData getSeekData() {
        if (redisCacheManager.hasKey("seekData")) {
            List<Object> seekData = redisCacheManager.lGet("seekData", 0, 1);
            return (SeekData) seekData.get(0);
        } else {
            SeekData seekData = new SeekData();
            List<GoodsBrand> goodsBrandList = goodsCategoryMapper.getGoodsBrandList();//商品品牌
            List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.getGoodsCategoryAndGoodsCategoryDetail();//商品二级分类
            seekData.setGoodsBrandList(goodsBrandList);
            seekData.setGoodsCategoryList(goodsCategoryList);
            redisCacheManager.lSet2("seekData", seekData, 3600);
            return seekData;
        }
    }

}
