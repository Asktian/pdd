package com.tw.pdd.mapper;

import com.tw.pdd.pojo.User;

public interface UserMapper {
    void addUser(User user);
    User getUserByPhone(String uuid);
    void updateUser(User user);
}
