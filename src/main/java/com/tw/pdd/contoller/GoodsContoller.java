package com.tw.pdd.contoller;

import com.tw.pdd.pojo.Goods;
import com.tw.pdd.pojo.QueryVo;
import com.tw.pdd.service.GoodsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "商品集合及商品详情")
@RestController
public class GoodsContoller {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "商品集合（封面）", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsCategoryDetailId", value = "二级分类ID", paramType = "query"),
            @ApiImplicitParam(name = "goodsName", value = "商品名称", paramType = "query")
    })
    @RequestMapping("/getGoodsByQueryVo")
    public List<Goods> getGoodsByQueryVo(@ApiIgnore QueryVo queryVo) {
        List<Goods> goodsList = goodsService.getGoodsByQueryVo(queryVo);
        return goodsList;
    }

    @ApiOperation(value = "商品详情", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品ID", paramType = "query")
    })
    @RequestMapping("/getGoodsAndDetails")
    public Goods getGoodsAndDetails(@ApiIgnore Integer goodsId) {
        Goods goodsAndDetails = goodsService.getGoodsAndDetails(goodsId);
        return goodsAndDetails;
    }
}
