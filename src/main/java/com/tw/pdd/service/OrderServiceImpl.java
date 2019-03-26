package com.tw.pdd.service;

import com.tw.pdd.mapper.OrderMapper;
import com.tw.pdd.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.IntStream;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountService accountService;

    @Override
    public State createOrder(CreateOrder createOrder) {
        State state = new State();//0.出错，1.成功生成订单且付款，2.生成订单成功，3.生成订单成功，但是余额不足变为待付款状态
        createOrder.setCreateTime(new Date());//生成订单创建时间
        String orderNo = new Date().getTime() + UUID.randomUUID().toString().replace("-", "").toLowerCase();//生成订单编号
        createOrder.setOrderNo(orderNo);//订单编号
        CreateOrderDetail createOrderDetail = new CreateOrderDetail();//信息转入创建订单详情
        createOrderDetail.setOrderNo(orderNo);//订单编号放入订单详情
        List<Integer> goodsId = createOrder.getGoodsId();//商品编号集合
        List<Integer> goodsNumber = createOrder.getGoodsNumber();//商品数量集合
        List<String> goodsSpec = createOrder.getGoodsSpec();//商品规格集合
        ArrayList<CreateOrderPojo> createOrderPojoList = new ArrayList<CreateOrderPojo>();//商品编号、数量、规格总集合
        IntStream.range(0, goodsNumber.size()).forEach(i -> {
            CreateOrderPojo createOrderPojo = new CreateOrderPojo(goodsId.get(i), goodsNumber.get(i), goodsSpec.get(i));
            createOrderPojoList.add(createOrderPojo);
            createOrderPojo = null;
        });
        createOrderDetail.setGoodsNumberAndGoodsIdList(createOrderPojoList);//放置商品编号和商品数量集合
        Integer pay_status = createOrder.getPayStatus();//获取支付状态
        //创建了订单但是没有付款
        if (pay_status == 0) {
            createOrder.setOrderStatus(0);
            orderMapper.createOrder(createOrder);
            createOrderDetail(createOrderDetail);
            state.setCode(2);
            return state;
        }
        //创建了订单并且付款
        if (pay_status == 1) {
            double orderMoney = createOrder.getOrderMoney();
            double balance = accountService.getBalanceByUUID(createOrder.getBuyerId());
            //当余额不足
            if (balance < orderMoney) {
                createOrder.setOrderStatus(0);
                orderMapper.createOrder(createOrder);
                createOrderDetail(createOrderDetail);
                state.setCode(3);
                return state;
            }
            accountService.payment(createOrder.getBuyerId(), orderMoney);//扣除对应用户账户余额
            createOrder.setPayTime(new Date());//生成支付时间
            createOrder.setOrderStatus(1);
            orderMapper.createOrder(createOrder);
            createOrderDetail(createOrderDetail);
            state.setCode(1);
            return state;
        }
        state.setCode(0);
        return state;

    }

    @Override
    public void createOrderDetail(CreateOrderDetail createOrderDetail) {
        orderMapper.createOrderDetail(createOrderDetail);
    }

    @Override
    public List<Order> getOrderByUserUUID(OrderQueryVo orderQueryVo) {
        System.out.println(orderQueryVo);
        List<Order> orderList = orderMapper.getOrderByUserUUID(orderQueryVo);
        return orderList;
    }

    @Override
    public State payOrder(CreateOrder createOrder) {
        State state = new State();
        double orderMoney = createOrder.getOrderMoney();
        double balance = accountService.getBalanceByUUID(createOrder.getBuyerId());
        if (balance < orderMoney) {
            state.setCode(0);
            return state;
        }
        createOrder.setOrderStatus(1);
        createOrder.setPayTime(new Date());
        createOrder.setPayStatus(1);
        orderMapper.payOrder(createOrder);
        state.setCode(1);
        return state;
    }
}
