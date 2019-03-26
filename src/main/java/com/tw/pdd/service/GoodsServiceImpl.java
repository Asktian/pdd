package com.tw.pdd.service;

import com.alibaba.fastjson.JSONObject;
import com.tw.pdd.mapper.GoodsMapper;
import com.tw.pdd.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsByQueryVo(QueryVo queryVo) {
        List<Goods> goodsList = goodsMapper.getGoodsByQueryVo(queryVo);
        return goodsList;
    }

    @Override
    public Goods getGoodsAndDetails(Integer id) {
        Goods goodsAndDetails = goodsMapper.getGoodsAndDetails(id);
        GoodsDetails goodsDetails = goodsAndDetails.getGoodsDetails();
        String imagesDetail = goodsDetails.getImagesDetail();
        String imagesDetail2 = goodsDetails.getImagesDetail2();
        String attribute = goodsDetails.getAttribute();
        List<Img> imagesDetailList = JSONObject.parseArray(imagesDetail, Img.class);
        List<Img> imagesDetailList2 = JSONObject.parseArray(imagesDetail2, Img.class);
        List<Attribute> attributeList = JSONObject.parseArray(attribute, Attribute.class);
        goodsDetails.setImagesDetail(null);
        goodsDetails.setImagesDetail2(null);
        goodsDetails.setImagesDetailList(imagesDetailList);
        goodsDetails.setImagesDetailList2(imagesDetailList2);
        goodsDetails.setAttribute(null);
        goodsDetails.setAttributeList(attributeList);
        List<SpecKey> specKeyList = goodsDetails.getSpecKeyList();
        for (SpecKey specKey : specKeyList) {
            List<SpecValue> specValueList = specKey.getSpecValueList();
            for (SpecValue specValue : specValueList) {
                String value = specValue.getValue();
                List<Value> valueList = JSONObject.parseArray(value, Value.class);
                specValue.setValueList(valueList);
                specValue.setValue(null);
            }
        }
        return goodsAndDetails;
    }
}
