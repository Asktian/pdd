package com.tw.pdd.service;

import com.tw.pdd.common.RedisCacheManager;
import com.tw.pdd.mapper.ActivityMapper;
import com.tw.pdd.pojo.ActivityDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 获取活动列表
     *
     * @param id
     * @return
     */
    @Override
    public ActivityDetail getActivityGoods(Integer id) {
        if (redisCacheManager.hasKey("activityGoods" + id)) {
            List<Object> activityGoods = redisCacheManager.lGet("activityGoods" + id, 0, 1);
            return (ActivityDetail) activityGoods.get(0);
        } else {
            ActivityDetail activityGoods = activityMapper.getActivityGoods(id);
            redisCacheManager.lSet2("activityGoods" + id, activityGoods, 3600);
            return activityGoods;
        }
    }
}
