package com.sise.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.*;
import com.sise.service.GoodsInfoService;
import com.sise.utils.RUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goodsInfo")
public class GoodsInfoController {

    @Autowired
    GoodsInfoService goodsInfoService;

    @Autowired
    RUtil rUtil;

    //更新进货信息
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public R update(@PathVariable int id, @RequestBody GoodsInfo goodsInfo){
        goodsInfoService.update(id, goodsInfo);
        return rUtil.getInstance(0, null, "更新成功！");
    }

    // 获取退货信息列表
    @RequestMapping(value = "/getReturnedList", method = RequestMethod.GET)
    public R getReturnedList(){
        List<GoodsInfo> goodsInfoList = goodsInfoService.getReturnedList();
        return rUtil.getInstance(0, goodsInfoList, "查询成功！");
    }

    //退货
    @RequestMapping(value = "/returnGoods/{id}", method = RequestMethod.PUT)
    public R returnGoods(@PathVariable int id){
        goodsInfoService.returnGoods(id);
        return rUtil.getInstance(0, null, "退货成功！");
    }

    // 查询进货信息
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public R findById(@PathVariable int id){
        GoodsInfo goodsInfo = goodsInfoService.findById(id);
        return rUtil.getInstance(0, goodsInfo, "查询成功！");
    }

    // 删除进货信息
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable int id){
        goodsInfoService.deleteById(id);
        return rUtil.getInstance(0, null, "删除成功！");
    }

    //添加进货记录
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody GoodsInfo goodsInfo){
        goodsInfoService.save(goodsInfo);
        return rUtil.getInstance(0, null, "添加成功！");
    }

    @RequestMapping(value = "/getGoodsInfoList/{currentPage}/{pageSize}", method = RequestMethod.POST)
    public R getGoodsInfoList(@PathVariable int currentPage, @PathVariable int pageSize, @RequestBody Map reqSearchMap){
        PageResult<GoodsInfo> pageResult = goodsInfoService.getGoodsInfoList(currentPage, pageSize, reqSearchMap);
        return rUtil.getInstance(0,pageResult,"查询成功");
    }
}
