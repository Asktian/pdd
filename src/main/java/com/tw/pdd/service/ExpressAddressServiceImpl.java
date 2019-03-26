package com.tw.pdd.service;

import com.tw.pdd.mapper.ExpressAddressMapper;
import com.tw.pdd.pojo.ExpressAddress;
import com.tw.pdd.pojo.UpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExpressAddressServiceImpl implements ExpressAddressService {
    @Autowired
    private ExpressAddressMapper expressAddressMapper;

    @Override
    public void createExpressAddressForUser(ExpressAddress expressAddress) {
        expressAddressMapper.createExpressAddressForUser(expressAddress);
    }

    @Override
    public void defaultAddress(UpdateVo updateVo) {
        expressAddressMapper.defaultAddress(updateVo);
    }

    @Override
    public List<ExpressAddress> getExpressAddressByUUID(String uuid) {
        List<ExpressAddress> expressAddressList = expressAddressMapper.getExpressAddressByUUID(uuid);
        return expressAddressList;
    }

    @Override
    public void updateExpressAddress(ExpressAddress expressAddress) {
        expressAddressMapper.updateExpressAddress(expressAddress);
    }

    @Override
    public void deleteExpressAddress(int id) {
        expressAddressMapper.deleteExpressAddress(id);
    }
}
