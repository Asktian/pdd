package com.tw.pdd.test;


import com.tw.pdd.mapper.UserMapper;
import com.tw.pdd.pojo.Goods;
import com.tw.pdd.pojo.QueryVo;
import com.tw.pdd.pojo.User;
import com.tw.pdd.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getGoodsByQueryVo() {
        QueryVo queryVo = new QueryVo();
        List<Goods> goodsByQueryVo = goodsService.getGoodsByQueryVo(queryVo);
        for (Goods goods : goodsByQueryVo) {
            System.out.println(goods);
        }
    }

    @Test
    public void user() {
        User user = new User();
        user.setUserPhone("13719664496");
        user.setUserName("王百逸");
        user.setAddress("广州现代");
        user.setSex("男");
        user.setBirthday(new Date());
        userMapper.addUser(user);
    }
}
