package com.tw.pdd.service;

public interface AccountService {
    Double getBalanceByUUID(String uuid);

    void payment(String uuid, Double balance);

    void createAccount(String uuid);
}
