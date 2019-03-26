package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderQueryVo implements Serializable {
    private  String uuid;
    private Integer orderStatus;
}
