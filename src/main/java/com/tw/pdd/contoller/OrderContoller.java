package com.tw.pdd.contoller;

import com.tw.pdd.pojo.CreateOrder;
import com.tw.pdd.pojo.Order;
import com.tw.pdd.pojo.OrderQueryVo;
import com.tw.pdd.pojo.State;
import com.tw.pdd.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "订单模块")
@RestController
public class OrderContoller {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "创建订单", httpMethod = "POST")
    @RequestMapping("/createOrder")
    public State createOrder(@RequestBody @ApiParam(name = "创建订单对象", value = "用时找CURD仔拿数据字段") CreateOrder createOrder) {
        State state = orderService.createOrder(createOrder);
        return state;
    }

    @ApiOperation(value = "查询用户所有订单", httpMethod = "GET")
    @RequestMapping("/getOrderList")
    public List<Order> getOrderList(OrderQueryVo orderQueryVo){
        List<Order> orderList = orderService.getOrderByUserUUID(orderQueryVo);
        return orderList;
    }

    @ApiOperation(value ="支付未支付订单", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "buyerId", value = "用户UUID", paramType = "query"),
            @ApiImplicitParam(name = "orderNo", value = "订单编号", paramType = "query"),
            @ApiImplicitParam(name = "orderMoney", value = "订单金额", paramType = "query")
    })
    @RequestMapping("/payOrder")
    public State payOrder(@ApiIgnore CreateOrder createOrder){
        State state = orderService.payOrder(createOrder);
        return state;
    }
}
