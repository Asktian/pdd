package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 二级分类
 */
@Data
public class GoodsCategoryDetail implements Serializable {
    private int id;//二级分类编号
    private String title;//二级分类名称
    private String icon;//二级分类图片
}
