package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 地址更新类
 */
@Data
public class UpdateVo implements Serializable {
    private int id;
    private String uuid;
}
