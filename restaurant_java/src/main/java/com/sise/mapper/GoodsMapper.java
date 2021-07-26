package com.sise.mapper;

import com.sise.entity.Goods;
import com.sise.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {

    @Select("select * from goods where sid = #{sid}")
    List<Goods> findBySid(int sid);

    @Select("select id, name from goods")
    List<GoodsVo> findGoodsIdAndName();
}
