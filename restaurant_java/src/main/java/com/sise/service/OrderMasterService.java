package com.sise.service;

import com.sise.entity.OrderMaster;
import com.sise.entity.PageResult;
import com.sise.vo.OrderDetailVo;

public interface OrderMasterService   {
    PageResult<OrderMaster> findByPage(int page, int perPage);

    OrderDetailVo findOrderDetail(int orderId);

    void finish(int orderId);

    void cancel(int orderId);
}
