package com.tw.pdd.mapper;

import com.tw.pdd.pojo.ExpressAddress;
import com.tw.pdd.pojo.UpdateVo;

import java.util.List;

public interface ExpressAddressMapper {
    void createExpressAddressForUser(ExpressAddress expressAddress);

    void defaultAddress(UpdateVo updateVo);

    List<ExpressAddress> getExpressAddressByUUID(String uuid);

    void updateExpressAddress(ExpressAddress expressAddress);

    void deleteExpressAddress(int id);
}
