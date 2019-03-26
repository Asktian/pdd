package com.tw.pdd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户账户
 */
@Data
public class Account implements Serializable {
    private String uuid;//用户编号
    private double balance;//账户余额

}
