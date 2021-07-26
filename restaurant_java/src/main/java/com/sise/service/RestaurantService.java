package com.sise.service;

import com.sise.entity.PageResult;
import com.sise.entity.Restaurant;

import java.util.Map;

public interface RestaurantService   {

    PageResult<Restaurant> findByPage(int currentPage, int pageSize, Map searchMap);

    void save(Restaurant restaurant);

    Restaurant findById(Long id);

    void update(Long id, Restaurant restaurant);

    void delete(Long id);
}
