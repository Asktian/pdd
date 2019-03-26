package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 城市
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class City implements Serializable {
    private Integer cityId;//城市编号
    private Integer provinceId;//省份编号
    private String cityName;//城市名称
    private String zipCode;//城市邮政编码
    private List<District> districtList;//城市下的区县集合
}
