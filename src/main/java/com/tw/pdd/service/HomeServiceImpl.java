package com.tw.pdd.service;

import com.tw.pdd.common.RedisCacheManager;
import com.tw.pdd.mapper.HomeNavMapper;
import com.tw.pdd.mapper.SlideShowMapper;
import com.tw.pdd.pojo.HomeData;
import com.tw.pdd.pojo.HomeNav;
import com.tw.pdd.pojo.SlideShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    @Autowired
    private SlideShowMapper slideShowMapper;

    @Autowired
    private HomeNavMapper homeNavMapper;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public HomeData getHome() {
        if (redisCacheManager.hasKey("homeData")) {
            List<Object> homes = redisCacheManager.lGet("homeData", 0, -1);
            HomeData homeData = (HomeData) homes.get(0);
            return homeData;
        } else {
            HomeData homeData = new HomeData();
            List<SlideShow> slideShowList = slideShowMapper.getSlideShowList();
            List<HomeNav> homeList = homeNavMapper.getHomeList();
            System.out.println(slideShowList);
            System.out.println(homeList);
            homeData.setSlideShowList(slideShowList);
            homeData.setHomeNavs(homeList);
            redisCacheManager.lSet2("homeData", homeData, 3600);
            return homeData;
        }
    }
}
