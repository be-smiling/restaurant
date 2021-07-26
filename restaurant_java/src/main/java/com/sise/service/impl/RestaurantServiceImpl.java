package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.mapper.RestaurantMapper;
import com.sise.entity.PageResult;
import com.sise.entity.Restaurant;
import com.sise.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantMapper restaurantMapper;

    @Override
    public PageResult<Restaurant> findByPage(int currentPage, int pageSize, Map searchMap) {
        String name = (String)searchMap.get("name");
        if (!ObjectUtils.isEmpty(name)){
            PageHelper.startPage(currentPage, pageSize);
            List<Restaurant> restaurantList = restaurantMapper.findNameLike("%"+name+"%");
            PageInfo<Restaurant> restaurantPageInfo = new PageInfo<>(restaurantList);
            return new PageResult<>(restaurantPageInfo.getTotal(), restaurantPageInfo.getList());
        }else {
            PageHelper.startPage(currentPage, pageSize);
            List<Restaurant> restaurantList = restaurantMapper.findAll();
            PageInfo<Restaurant> restaurantPageInfo = new PageInfo<>(restaurantList);
            return new PageResult<>(restaurantPageInfo.getTotal(), restaurantPageInfo.getList());
        }
    }

    @Override
    public void save(Restaurant restaurant) {
        restaurantMapper.save(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantMapper.findById(id);
    }

    @Override
    public void update(Long id, Restaurant restaurant) {
        restaurant.setId(id);
        restaurantMapper.update(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantMapper.delete(id);
    }
}
