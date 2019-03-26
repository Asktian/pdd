package com.tw.pdd.test;

import com.tw.pdd.common.RedisCacheManager;
import com.tw.pdd.mapper.DistrictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class ResdisTest {
    @Autowired
    private RedisCacheManager redisCacheManager;

    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void test() {
        if (redisCacheManager.hasKey("provinceList")) {
            System.out.println("provinceList存在");
            List<Object> provinceList = redisCacheManager.lGet("provinceList", 0, -1);
            System.out.println(provinceList);
        } else {
            System.out.println("provinceList不存在");
            List<Object> provinceList = districtMapper.getProvinceList();
            redisCacheManager.lSet("provinceList", provinceList, 30);
            System.out.println(provinceList);
        }
    }

    @Test
    public void test1() {
        redisCacheManager.del("cityListByProvinceId3");
        System.out.println(redisCacheManager.hasKey("cityListByProvinceId3"));
        long activityGoods18 = redisCacheManager.getExpire("cityListByProvinceId3");
        System.out.println(activityGoods18);
    }

}
