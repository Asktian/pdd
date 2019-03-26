package com.tw.pdd.service;

import com.tw.pdd.mapper.AccountMapper;
import com.tw.pdd.mapper.UserMapper;
import com.tw.pdd.pojo.User;
import com.tw.pdd.utils.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public User login(User user) {
        String userPhone = user.getUserPhone();
        User user2 = getUserByPhone(userPhone);
        if (user2 == null) {
            user.setUserName(userPhone);
            userMapper.addUser(user);
            System.out.println(user);
            accountMapper.createAccount(user.getUuid());
            return user;
        }
        return user2;
    }

    @Override
    public String getCode(String mobile) {
        String code = SMS.sendCode(mobile);
        return code;
    }

    @Override
    public User getUserByPhone(String userPhone) {
        User user = userMapper.getUserByPhone(userPhone);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return getUserByPhone(user.getUserPhone());
    }
}
