package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.mapper.GoodsMapper;
import com.sise.entity.Goods;
import com.sise.entity.PageResult;
import com.sise.service.GoodsService;
import com.sise.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 根据条件分页查
     * @param searchMap 包含某个供应商的sid
     * @return
     */
    @Override
    public PageResult<Goods> findBySearchMap(int currentPage, int pageSize, Map searchMap) {

        PageHelper.startPage(currentPage, pageSize);
        List<Goods> goodsList = goodsMapper.findBySid((Integer)searchMap.get("sid"));
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        return new PageResult<>(goodsPageInfo.getTotal(), goodsPageInfo.getList());
    }

    /**
     * 返回商品的id和名称
     * @return
     */
    @Override
    public List<GoodsVo> getGoodsList() {

        List<GoodsVo> goodsVoList = goodsMapper.findGoodsIdAndName();
        return goodsVoList;
    }
}
