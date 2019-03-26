package com.tw.pdd.contoller;

import com.tw.pdd.pojo.SeekData;
import com.tw.pdd.service.GoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "商品分类")
@RestController
public class GoodsCategoryContoller {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @ApiOperation(value = "首页顶部分类列表", httpMethod = "POST")
    @RequestMapping("/getGoodsCategoryList")
    public List<Object> getGoodsCategoryList() {
        List<Object> goodsCategoryList = goodsCategoryService.getGoodsCategoryList();
        return goodsCategoryList;
    }

    @ApiOperation(value = "分类与二级分类", httpMethod = "POST")
    @RequestMapping("/getCategoryAndGoods")
    public SeekData getSeekData(){
        SeekData seekData = goodsCategoryService.getSeekData();
        return  seekData;
    }
}
