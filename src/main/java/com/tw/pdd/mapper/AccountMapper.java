package com.tw.pdd.mapper;

public interface AccountMapper {
    Double getBalanceByUUID(String uuid);

    void payment(String uuid, Double balance);

    void createAccount(String uuid);
}
