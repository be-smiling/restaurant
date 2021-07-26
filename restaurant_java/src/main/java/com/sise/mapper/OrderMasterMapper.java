package com.sise.mapper;

import com.sise.entity.OrderMaster;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMasterMapper {

    @Select("select * from order_master order by order_id desc")
    @Results(id = "orderMaster", value = {
            @Result(id = true, property = "orderId", column = "order_id"),
            @Result(property = "orderNumber", column = "order_number"),
            @Result(property = "userOpenid", column = "user_openid"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "tableNumber", column = "table_number"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "payStatus", column = "pay_status"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "status", column = "status_")
    })
    List<OrderMaster> findAll();

    @Select("select * from order_master where order_id = #{orderId}")
    @ResultMap(value = {"orderMaster"})
    OrderMaster findById(int orderId);
}
