package com.sise.mapper;

import com.sise.entity.OrderDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDetailMapper {


    @Select("select * from order_detail where order_id = #{orderId}")
    @Results(id = "orderDetail", value = {
            @Result(id = true, property = "detailId", column = "detail_id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "menuId", column = "menu_id"),
            @Result(property = "menuName", column = "menu_name"),
            @Result(property = "menuPrice", column = "menu_price"),
            @Result(property = "menuQuantity", column = "menu_quantity"),
            @Result(property = "menuIcon", column = "menu_icon"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "status", column = "status_")
    })
    List<OrderDetail> findByOrderId(Long orderId);

    @Update("update order_master set order_status = 1 where order_id = #{orderId}")
    void finish(int orderId);

    @Update("update order_master set order_status = 2 where order_id = #{orderId}")
    void cancel(int orderId);
}
