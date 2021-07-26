package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.mapper.GoodsInfoMapper;
import com.sise.entity.GoodsInfo;
import com.sise.entity.GoodsInfoExample;
import com.sise.entity.PageResult;
import com.sise.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    @Override
    public PageResult<GoodsInfo> getGoodsInfoList(int currentPage, int pageSize, Map searchMap) {
        //拼接条件查询对象
        GoodsInfoExample goodsInfoExample = new GoodsInfoExample();
        GoodsInfoExample.Criteria criteria = goodsInfoExample.createCriteria();
        if (!ObjectUtils.isEmpty(searchMap.get("supplierName")) && !StringUtils.isEmpty(searchMap.get("supplierName"))){
            criteria.andSupplierNameLike("%" + (String)searchMap.get("supplierName")+ "%");
        }
        if (!ObjectUtils.isEmpty(searchMap.get("goodsName")) && !StringUtils.isEmpty(searchMap.get("goodsName"))){
            criteria.andGoodsNameLike("%" +(String)searchMap.get("goodsName")+ "%");
        }
        if (!ObjectUtils.isEmpty(searchMap.get("purchaseTime")) && !StringUtils.isEmpty(searchMap.get("purchaseTime"))){
            criteria.andPurchaseTimeLike("%" + (String)searchMap.get("purchaseTime") + "%");
        }
        criteria.andReturnedNotEqualTo((new Byte("1")));
        PageHelper.startPage(currentPage, pageSize);
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectByExample(goodsInfoExample);
        PageInfo<GoodsInfo> goodsInfoPageInfo = new PageInfo<>(goodsInfoList);
        return new PageResult<>(goodsInfoPageInfo.getTotal(), goodsInfoPageInfo.getList());
    }

    @Override
    public void save(GoodsInfo goodsInfo) {
        goodsInfo.setPurchaseTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        goodsInfo.setReturned(Byte.parseByte("0"));
        goodsInfoMapper.save(goodsInfo);
    }

    @Override
    public void deleteById(int id) {
        goodsInfoMapper.deleteById(id);
    }

    @Override
    public GoodsInfo findById(int id) {
        return goodsInfoMapper.findById(id);
    }

    // 退货
    @Override
    public void returnGoods(int id) {
//        更新商品信息表的returned字段
        goodsInfoMapper.updateReturned(id);
    }

    @Override
    public List<GoodsInfo> getReturnedList() {
        return goodsInfoMapper.getReturnedList();
    }

    @Override
    public void update(int id, GoodsInfo goodsInfo) {
        goodsInfo.setId(id);
        goodsInfoMapper.update(goodsInfo);
    }
}
