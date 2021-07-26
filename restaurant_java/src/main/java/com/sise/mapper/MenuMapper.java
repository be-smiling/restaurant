package com.sise.mapper;

import com.sise.entity.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {

    @Select("select * from menu order by id desc")
    List<Menu> findAll();

    @Insert("insert into menu values(null, #{name}, #{price}, #{description}, #{url}, #{isCollected}, #{status})")
    void add(Menu menu);

    @Select("select * from menu where id = #{id}")
    Menu findById(Long id);

    @Update("update menu set name = #{name}, price = #{price}, url = #{url} where id = #{id}")
    void update(Menu menu);

    @Delete("delete from menu where id = #{id}")
    void delete(Long id);
}
