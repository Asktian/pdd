package com.tw.pdd.mapper;

import com.tw.pdd.pojo.Province;

import java.util.List;

public interface DistrictMapper {
    List<Province> getDistrictList();

    List<Object> getProvinceList();

    List<Object> getCityListByProvinceId(int provinceId);

    List<Object> getDistrictListByCityId(int cityId);

}
