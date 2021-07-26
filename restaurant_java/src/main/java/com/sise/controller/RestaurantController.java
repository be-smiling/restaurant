package com.sise.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.*;
import com.sise.service.RestaurantService;
import com.sise.utils.RUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RUtil rUtil;

    //删除分店
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable Long id){
        restaurantService.delete(id);
        return rUtil.getInstance(0, null, "删除成功!");
    }

    //修改分店信息
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public R update(@PathVariable Long id, @RequestBody Restaurant restaurant){
        restaurantService.update(id, restaurant);
        return rUtil.getInstance(0, null, "更新成功!");
    }

    //查询分店
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public R findById(@PathVariable Long id){
        Restaurant restaurant = restaurantService.findById(id);
        return rUtil.getInstance(0, restaurant, "查询成功!");
    }

    //保存分店
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody Restaurant restaurant){
        restaurantService.save(restaurant);
        return rUtil.getInstance(0, restaurant, "保存成功!");
    }


    //查询分店带分页
    @RequestMapping(value = "/findByPage/{currentPage}/{pageSize}", method = RequestMethod.POST)
    public R findByPage(@PathVariable int currentPage, @PathVariable int pageSize, @RequestBody Map searchMap){
        PageResult<Restaurant> pageResult = restaurantService.findByPage(currentPage, pageSize, searchMap);
        return rUtil.getInstance(0, pageResult, "查询成功!");
    }

}
