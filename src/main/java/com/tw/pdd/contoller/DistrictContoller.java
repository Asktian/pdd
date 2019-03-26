package com.tw.pdd.contoller;

import com.tw.pdd.service.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "地区模块")
@RestController
public class DistrictContoller {

    @Autowired
    private DistrictService districtService;

    @ApiOperation(value = "获取省份列表", httpMethod = "GET")
    @RequestMapping("/getProvinceList")
    public List<Object> getProvinceList() {
        List<Object> provinceList = districtService.getProvinceList();
        return provinceList;
    }

    @ApiOperation(value="根据省份编号获取城市列表", httpMethod = "GET")
    @RequestMapping("/getCityListByProvinceId")
    public List<Object> getCityListByProvinceId(int provinceId) {
        List<Object> cityListByProvinceId = districtService.getCityListByProvinceId(provinceId);
        return cityListByProvinceId;
    }

    @ApiOperation(value="根据城市编号获取区县列表", httpMethod = "GET")
    @RequestMapping("/getDistrictListByCityId")
    public List<Object> getDistrictListByCityId(int cityId) {
        List<Object> districtListByCityId = districtService.getDistrictListByCityId(cityId);
        return districtListByCityId;
    }
}
