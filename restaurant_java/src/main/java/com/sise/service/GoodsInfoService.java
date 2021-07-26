package com.sise.service;

import com.sise.entity.GoodsInfo;
import com.sise.entity.PageResult;

import java.util.List;
import java.util.Map;

public interface GoodsInfoService  {
    PageResult<GoodsInfo> getGoodsInfoList(int currentPage, int pageSize, Map searchMap);

    void save(GoodsInfo goodsInfo);

    void deleteById(int id);

    GoodsInfo findById(int id);

    void returnGoods(int id);

    List<GoodsInfo> getReturnedList();

    void update(int id, GoodsInfo goodsInfo);
}
