package com.sise.mapper;

import com.sise.mapper.RestaurantMapper;
import com.sise.entity.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantMapperTest {

    @Autowired
    RestaurantMapper restaurantMapper;

    @Test
    public void findNameLike() {
        List<Restaurant> restaurantList = restaurantMapper.findNameLike("%10%");
        //断言0与restaurantList.size()不相等则测试通过
        Assert.assertNotEquals(0, restaurantList.size());
    }

    @Test
    public void findAll() {
        List<Restaurant> restaurantList = restaurantMapper.findAll();
        Assert.assertNotEquals(0, restaurantList.size());
    }

    @Test
    public void findByPageAndNameLike() {
        // 先全部查出分店名称包含5的，再从0条开始截取10条
        List<Restaurant> restaurantList = restaurantMapper.findByPageAndNameLike(0, 10, "%5%");
        // 数据库中分店名称包含5的有2条记录
        Assert.assertEquals(2, restaurantList.size());
    }

    @Test
    public void findByPage() {
        //从起始索引1开始查，查10条
        List<Restaurant> restaurantList = restaurantMapper.findByPage(0, 10);
        Assert.assertEquals(10, restaurantList.size());
    }

    @Test
    public void save() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(28l);
        restaurantMapper.save(restaurant);
        Restaurant newRestaurant = restaurantMapper.findById(28l);
        System.out.println(newRestaurant);
        Assert.assertNotNull(newRestaurant);
    }

    @Test
    public void findById() {
        Restaurant restaurant = restaurantMapper.findById(1l);
        Assert.assertEquals(new Long(1), restaurant.getId());
    }

    @Test
    public void update() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(17l);
        restaurant.setName("分店17llll");
        restaurantMapper.update(restaurant);
        Restaurant updateRestaurant = restaurantMapper.findById(17l);
        Assert.assertEquals(updateRestaurant.getName(), "分店20llll");
    }

    @Test
    public void delete() {
        restaurantMapper.delete(20l);
        Restaurant restaurant = restaurantMapper.findById(20l);
        Assert.assertNull(restaurant);
    }


}
