package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 顶部导航
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class HomeNav implements Serializable {
    private int id;//活动编号
    private String iconurl;//活动图片
    private String icontitle;//活动标题
    private boolean flag;//是否展示
}
