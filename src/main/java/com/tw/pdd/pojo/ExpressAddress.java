package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 收货地址模板
 */
@Data
public class ExpressAddress implements Serializable {
    private int id;//模板编号
    private String uid;//用户编号
    private String consigner;//收货人名称
    private String mobile;//联系电话
    private int province;//所在省份
    private int city;//所在城市
    private int district;//所在区域
    private String address;//详细地址
    private boolean flag;//是否设为默认
    private Province provinces;
}
