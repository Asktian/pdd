package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 省份
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Province implements Serializable {
    private int provinceId;//省份编号
    private String provinceName;//省份名称
    private List<City> cityList;//城市集合
}
