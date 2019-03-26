package com.tw.pdd.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class User implements Serializable {
    private String uuid;//用户编号
    private String userPhone;//用户手机
    private String userName;//用户昵称
    private String sex;//用户性别
    private String address;//用户地址
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;//用户生日
    private String sign;//个性签名
}
