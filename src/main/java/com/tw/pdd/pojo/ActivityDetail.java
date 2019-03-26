package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 活动详情
 */
@Data
public class ActivityDetail implements Serializable {
    private int id;//活动详情编号
    private List<Goods> goodsList;//活动商品集合
}
