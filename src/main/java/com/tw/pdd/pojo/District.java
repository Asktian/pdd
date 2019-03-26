package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 区县
 */
@Data
public class District implements Serializable {
    private int districtId;//区县编号
    private int cityId;//城市编号
    private String districtName;//区县名称
}
