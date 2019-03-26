package com.tw.pdd.mapper;

import com.tw.pdd.pojo.CreateOrder;
import com.tw.pdd.pojo.CreateOrderDetail;
import com.tw.pdd.pojo.Order;
import com.tw.pdd.pojo.OrderQueryVo;

import java.util.List;

public interface OrderMapper {
    void createOrder(CreateOrder createOrder);

    List<Order> getOrderByUserUUID(OrderQueryVo orderQueryVo);

    void createOrderDetail(CreateOrderDetail createOrderDetail);

    void payOrder(CreateOrder createOrder);
}
