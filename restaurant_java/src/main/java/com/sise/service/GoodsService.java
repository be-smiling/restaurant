package com.sise.service;

import com.sise.entity.Goods;
import com.sise.entity.PageResult;
import com.sise.vo.GoodsVo;

import java.util.List;
import java.util.Map;

public interface GoodsService   {
    PageResult<Goods> findBySearchMap(int currentPage, int pageSize, Map searchMap);

    List<GoodsVo> getGoodsList();
}
