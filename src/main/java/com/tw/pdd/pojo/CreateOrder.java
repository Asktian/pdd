package com.tw.pdd.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CreateOrder implements Serializable {
    private String orderNo;//订单编号
    private String buyerId;//用户ID
    private String userName;//用户昵称
    private String receiverMobile;//收货人联系电话
    private Integer receiverProvince;//收货省份
    private Integer receiverCity;//收货城市
    private Integer receiverDistrict;//收货区县
    private String receiverAddress;//收货详细地址
    private String receiverName;//收货人姓名
    private Double orderMoney;//订单总金额
    private Integer orderStatus;//订单状态 0.待付款，1.已付款，2.待发货，3.待收货，4.待评价，5.已完成
    private Integer payStatus;//支付状态  0.不支付，1.支付
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTime;//支付时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//订单创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishTime;//订单结束时间
    private List<String> goodsSpec;//商品规格
    private List<Integer> goodsId;//商品编号集合
    private List<Integer> goodsNumber;//商品数量集合
}
