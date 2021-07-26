package com.sise.service.impl;

import com.sise.entity.PageResult;
import com.sise.entity.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTest {

    @Autowired
    RestaurantServiceImpl restaurantService;

    // 测试查询分店列表
    @Test
    public void findByPage() {
        Map<Object, Object> searchMap = new HashMap<>();
        PageResult<Restaurant> pageResult =  restaurantService.findByPage(1, 10, searchMap);
        Assert.assertTrue("查询所有的分店列表", pageResult.getTotal() > 0);
        Assert.assertNotEquals(0, pageResult.getRows().size());
    }

    // 测试根据分店id查询分店
    @Test
    public void findById() {
        Restaurant restaurant = restaurantService.findById(1l);
        Assert.assertEquals(new Long(1), restaurant.getId());
    }
}