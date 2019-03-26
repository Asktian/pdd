package com.tw.pdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 轮播图与顶部列表
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class HomeData implements Serializable {
    private List<SlideShow> slideShowList;//轮播图集合
    private List<HomeNav> homeNavs;//活动集合
}
