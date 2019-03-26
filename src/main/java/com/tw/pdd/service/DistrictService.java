package com.tw.pdd.service;

import java.util.List;

public interface DistrictService {
    /*List<Province> getDistrictList();*/

    List<Object> getProvinceList();

    List<Object> getCityListByProvinceId(int provinceId);

    List<Object> getDistrictListByCityId(int cityId);
}
