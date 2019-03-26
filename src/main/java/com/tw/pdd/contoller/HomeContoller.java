package com.tw.pdd.contoller;

import com.tw.pdd.pojo.HomeData;
import com.tw.pdd.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "首页")
@RestController
public class HomeContoller {
    @Autowired
    private HomeService homeService;

    @ApiOperation(value="九宫格，轮播图", httpMethod = "POST")
    @RequestMapping("/getHomeData")
    public HomeData getHomeData(){
        HomeData home = homeService.getHome();
        return home;
    }
}
