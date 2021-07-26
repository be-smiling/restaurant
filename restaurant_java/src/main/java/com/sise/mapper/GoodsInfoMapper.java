package com.sise.mapper;

import com.sise.entity.GoodsInfo;
import com.sise.entity.GoodsInfoExample;
import com.sise.mapper.providers.GoodsInfoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsInfoMapper {

    @SelectProvider(type= GoodsInfoSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="supplier_name", property="supplierName", jdbcType=JdbcType.VARCHAR),
            @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
            @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
            @Result(column="purchase_time", property="purchaseTime", jdbcType=JdbcType.VARCHAR),
            @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
            @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.INTEGER),
            @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column="returned", property="returned", jdbcType=JdbcType.TINYINT)
    })
    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    @Select("select * from goods_info")
    @Results(id = "goodsInfo", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "supplierName", column = "supplier_name"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "payType", column = "pay_type"),
            @Result(property = "purchaseTime", column = "purchase_time"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "totalPrice", column = "total_price"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "returned", column = "returned")
    })
    List<GoodsInfo> findAll();

    @Insert("insert into goods_info values (null, #{supplierName}, #{goodsName}, #{payType}, #{purchaseTime}, #{quantity}, #{totalPrice}, #{remark}, #{returned})")
    void save(GoodsInfo goodsInfo);

    @Delete("delete from goods_info where id = #{id}")
    void deleteById(int id);

    @Select("select * from goods_info where id = #{id}")
    @ResultMap(value = {"goodsInfo"})
    GoodsInfo findById(int id);

    @Update("update goods_info set returned = 1 where id = #{id}")
    void updateReturned(int id);

    @Select("select * from goods_info where returned = 1 order by id desc")
    @ResultMap(value = {"goodsInfo"})
    List<GoodsInfo> getReturnedList();

    @Update("update goods_info set supplier_name = #{supplierName}, goods_name = #{goodsName}, pay_type = #{payType}, purchase_time = #{purchaseTime}, quantity = #{quantity}, total_price = #{totalPrice}, remark = #{remark} where id = #{id}")
    void update(GoodsInfo goodsInfo);
}
