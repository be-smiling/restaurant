package com.sise.mapper;

import com.sise.entity.Restaurant;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RestaurantMapper {

    @Select("select * from restaurant where name like #{name}")
    List<Restaurant> findNameLike(String name);

    @Select("select * from restaurant order by id desc")
    @Results(id = "restaurant", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "manager", column = "manager"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "address", column = "address"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "status", column = "status_")
    })
    List<Restaurant> findAll();

    @Select("select * from restaurant where name like #{param3} limit #{param1}, #{param2}")
    List<Restaurant> findByPageAndNameLike(int beginIndex, int count, String name);

    @Select("select * from restaurant limit #{param1}, #{param2}")
    List<Restaurant> findByPage(int beginIndex, int count);

    @Insert("insert into restaurant values (null, #{name}, #{manager}, #{phone}, #{address}, #{startTime}, 0)")
    void save(Restaurant restaurant);

    @Select("select * from restaurant where id = #{id}")
    Restaurant findById(Long id);

    @Update("update restaurant set name = #{name}, phone = #{phone}, address = #{address}, start_time = #{startTime} where id = #{id}")
    void update(Restaurant restaurant);

    @Delete("delete from restaurant where id = #{id}")
    void delete(Long id);
}
