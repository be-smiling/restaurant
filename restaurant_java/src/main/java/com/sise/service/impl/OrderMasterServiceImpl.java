package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.mapper.OrderDetailMapper;
import com.sise.mapper.OrderMasterMapper;
import com.sise.entity.OrderDetail;
import com.sise.entity.OrderMaster;
import com.sise.entity.PageResult;
import com.sise.service.OrderMasterService;
import com.sise.vo.OrderDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    OrderMasterMapper orderMasterMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    NumberFormat nf = NumberFormat.getInstance();

    @Override
    public PageResult<OrderMaster> findByPage(int page, int perPage) {
        PageHelper.startPage(page, perPage);
        List<OrderMaster> orderMasterList = orderMasterMapper.findAll();
        for (OrderMaster orderMaster : orderMasterList) {
            orderMaster.setOrderAmount(new BigDecimal(nf.format(orderMaster.getOrderAmount().multiply(new BigDecimal(0.01)))));
        }
        PageInfo<OrderMaster> orderMasterPageInfo = new PageInfo<>(orderMasterList);
        return new PageResult<>(orderMasterPageInfo.getTotal(), orderMasterPageInfo.getList());
    }

    @Override
    public OrderDetailVo findOrderDetail(int orderId) {
        OrderMaster orderMaster = orderMasterMapper.findById(orderId);
        orderMaster.setOrderAmount(new BigDecimal(nf.format(orderMaster.getOrderAmount().multiply(new BigDecimal(0.01)))));
        List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderId(orderMaster.getOrderId());
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetail.setMenuPrice(new BigDecimal(nf.format(orderDetail.getMenuPrice().multiply(new BigDecimal(0.01)))));
        }
        OrderDetailVo orderDetailVO = new OrderDetailVo();
        BeanUtils.copyProperties(orderMaster, orderDetailVO);
        orderDetailVO.setOrderDetailList(orderDetailList);
        return orderDetailVO;
    }

    @Override
    public void finish(int orderId) {
        orderDetailMapper.finish(orderId);
    }

    @Override
    public void cancel(int orderId) {
        orderDetailMapper.cancel(orderId);
    }
}
