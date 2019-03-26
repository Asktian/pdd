package com.tw.pdd.contoller;

import com.tw.pdd.pojo.ExpressAddress;
import com.tw.pdd.pojo.UpdateVo;
import com.tw.pdd.service.ExpressAddressService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "用户地址模块")
@RestController
public class ExpressAddressContoller {
    @Autowired
    private ExpressAddressService expressAddressService;

    @ApiOperation(value = "创建用户地址模板(一定为POST)", httpMethod = "POST")
    @RequestMapping("/createExpressAddressForUser")
    public String createExpressAddressForUser(@RequestBody @ApiParam(name = "地址对象", value = "用时沟通") ExpressAddress expressAddress) {
        expressAddressService.createExpressAddressForUser(expressAddress);
        return "ok";
    }

    @ApiOperation(value = "设置默认地址", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址模板编号", paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户uuid", paramType = "query")
    })
    @RequestMapping("/defaultAddress")
    public String defaultAddress(@ApiIgnore UpdateVo updateVo) {
        expressAddressService.defaultAddress(updateVo);
        return "ok";
    }

    @ApiOperation(value = "获取用户地址模板集合", httpMethod = "GET")
    @RequestMapping("/getExpressAddressByUUID")
    public List<ExpressAddress> getExpressAddressByUUID(String uuid) {
        List<ExpressAddress> expressAddress = expressAddressService.getExpressAddressByUUID(uuid);
        return expressAddress;
    }

    @ApiOperation(value = "修改用户地址模板", httpMethod = "POST")
    @RequestMapping("/updateExpressAddress")
    public String updateExpressAddress(@RequestBody @ApiParam(name = "地址对象", value = "用时沟通") ExpressAddress expressAddress) {
        expressAddressService.updateExpressAddress(expressAddress);
        return "ok";
    }

    @ApiOperation(value = "删除用户地址模板", httpMethod = "GET")
    @RequestMapping("deleteExpressAddress")
    public String ll(int id) {
        expressAddressService.deleteExpressAddress(id);
        return "ok";
    }
}
