package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 规格键
 */
@Data
public class SpecKey implements Serializable {
    private int id;//规格编号
    private String title;//规格标题
    private List<SpecValue> specValueList;//规格值集合
}
