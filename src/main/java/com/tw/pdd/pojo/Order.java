package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Order implements Serializable {
    private String orderNo;
    private String buyerId;
    private String userName;
    private String receiverMobile;
    private String receiverAddress;
    private String receiverName;
    private double orderMoney;
    private int orderStatus;//订单状态 0.待付款，1.已付款，2.待发货，3.待收货，4.待评价，5.已完成
    private int payStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishTime;
    private boolean flag;
    private Province province;
    private City city;
    private District district;
    private List<OrderDetail> orderDetailList;
}
