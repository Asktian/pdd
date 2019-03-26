package com.tw.pdd.service;

import com.tw.pdd.pojo.User;

public interface UserService {
    User login(User user);

    String getCode(String mobile);

    User getUserByPhone(String uuid);

    User updateUser(User user);
}
