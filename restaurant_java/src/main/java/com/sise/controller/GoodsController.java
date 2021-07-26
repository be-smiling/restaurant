package com.sise.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.*;
import com.sise.service.GoodsService;
import com.sise.utils.RUtil;
import com.sise.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    GoodsService goodsService;

    @Autowired
    RUtil rUtil;

    /**
     * 查询所有商品的id和名称
     * @return
     */
    @RequestMapping(value = "/getGoodsList", method = RequestMethod.GET)
    public R getGoodsList(){
        List<GoodsVo> goodsVoList = goodsService.getGoodsList();
        return rUtil.getInstance(0, goodsVoList, "查询成功");
    }

    /**
     * 根据条件分页查
     * @return
     */
    @RequestMapping(value = "/findBySid/{currentPage}/{pageSize}", method = RequestMethod.POST)
    public R findBySid(@PathVariable int currentPage, @PathVariable int pageSize, @RequestBody Map searchMap){
        PageResult<Goods> pageResult = goodsService.findBySearchMap(currentPage, pageSize, searchMap);
        return rUtil.getInstance(0, pageResult, "查询成功");
    }
}
