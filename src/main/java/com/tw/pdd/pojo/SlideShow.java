package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 轮播图
 */
@Data
public class SlideShow implements Serializable {
    private String imgurl;//轮播图地址
    private String detail;//轮播图跳转地址
    private boolean flag;//是否展示
}
