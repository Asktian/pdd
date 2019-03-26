package com.tw.pdd.contoller;

import com.tw.pdd.pojo.ActivityDetail;
import com.tw.pdd.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "活动商品")
@RestController
public class ActivityContoller {

    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "获取活动商品", httpMethod = "GET")
    @RequestMapping("/getActivityGoods")
    public ActivityDetail getActivityGoods(Integer id) {
        ActivityDetail activityGoods = activityService.getActivityGoods(id);
        return activityGoods;
    }
}
