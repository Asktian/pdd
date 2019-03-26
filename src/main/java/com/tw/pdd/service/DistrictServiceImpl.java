package com.tw.pdd.service;

import com.tw.pdd.common.RedisCacheManager;
import com.tw.pdd.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private RedisCacheManager redisCacheManager;

   /* @Override
    public List<Province> getDistrictList() {
        List<Province> districtList = districtMapper.getDistrictList();
        return districtList;
    }*/

    /**
     * 获取省份列表
     *
     * @return
     */
    @Override
    public List<Object> getProvinceList() {
        if (redisCacheManager.hasKey("provinceList")) {
            List<Object> provinceList = redisCacheManager.lGet("provinceList", 0, -1);
            return provinceList;
        } else {
            List<Object> provinceList = districtMapper.getProvinceList();
            redisCacheManager.lSet("provinceList", provinceList, 3600);
            return provinceList;
        }

    }

    /**
     * 获取某省的城市列表
     *
     * @param provinceId 省份编号
     * @return
     */
    @Override
    public List<Object> getCityListByProvinceId(int provinceId) {
        if (redisCacheManager.hasKey("cityListByProvinceId" + provinceId)) {
            return redisCacheManager.lGet("cityListByProvinceId" + provinceId, 0, -1);
        } else {
            List<Object> cityListByProvinceId = districtMapper.getCityListByProvinceId(provinceId);
            redisCacheManager.lSet("cityListByProvinceId" + provinceId, cityListByProvinceId, 3600);
            return cityListByProvinceId;
        }
    }

    /**
     * 获取某城的区县列表
     *
     * @param cityId 城市编号
     * @return
     */
    @Override
    public List<Object> getDistrictListByCityId(int cityId) {
        if (redisCacheManager.hasKey("getDistrictListByCityId" + cityId)) {
            return redisCacheManager.lGet("getDistrictListByCityId" + cityId, 0, -1);
        } else {
            List<Object> districtListByCityId = districtMapper.getDistrictListByCityId(cityId);
            redisCacheManager.lSet("getDistrictListByCityId" + cityId, districtListByCityId, 3600);
            return districtListByCityId;
        }
    }
}
