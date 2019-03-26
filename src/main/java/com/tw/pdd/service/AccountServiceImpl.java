package com.tw.pdd.service;

import com.tw.pdd.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Double getBalanceByUUID(String uuid) {
        Double balance = accountMapper.getBalanceByUUID(uuid);
        return balance;
    }

    @Override
    public void payment(String uuid, Double balance) {
        accountMapper.payment(uuid, balance);
    }

    @Override
    public void createAccount(String uuid) {
        accountMapper.createAccount(uuid);
    }
}
