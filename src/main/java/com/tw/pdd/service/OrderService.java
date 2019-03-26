package com.tw.pdd.service;

import com.tw.pdd.pojo.*;

import java.util.List;

public interface OrderService {
    State createOrder(CreateOrder createOrder);

    void createOrderDetail(CreateOrderDetail createOrderDetail);

    List<Order> getOrderByUserUUID(OrderQueryVo orderQueryVo);

    State payOrder(CreateOrder createOrder);
}
