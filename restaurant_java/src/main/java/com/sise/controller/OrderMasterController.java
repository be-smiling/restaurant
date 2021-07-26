package com.sise.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.*;
import com.sise.service.OrderMasterService;
import com.sise.utils.RUtil;
import com.sise.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/orderMaster")
public class OrderMasterController {

    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    RUtil rUtil;

    //取消订单
    @RequestMapping(value = "/cancel/{orderId}", method = RequestMethod.PUT)
    public R cancel(@PathVariable int orderId){
        orderMasterService.cancel(orderId);
        return rUtil.getInstance(0, null, "订单已取消");
    }

    //完结订单
    @RequestMapping(value = "/finish/{orderId}", method = RequestMethod.PUT)
    public R finish(@PathVariable int orderId){
        orderMasterService.finish(orderId);
        return rUtil.getInstance(0, null, "订单已完结");
    }

    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public R detail(@PathVariable int orderId){
        OrderDetailVo orderDetailVO = orderMasterService.findOrderDetail(orderId);
        return rUtil.getInstance(0, orderDetailVO, "查询成功!");
    }

    @RequestMapping(value = "/findByPage/{page}/{perPage}", method = RequestMethod.POST)
    public R findByPage(@PathVariable int page, @PathVariable int perPage, HttpServletRequest request){
        PageResult<OrderMaster> pageResult = orderMasterService.findByPage(page, perPage);
        return rUtil.getInstance(0, pageResult, "查询成功!");
    }

    @RequestMapping(value = "/record/{page}/{perPage}", method = RequestMethod.POST)
    public R record(@PathVariable int page, @PathVariable int perPage){
        PageResult<OrderMaster> pageResult = orderMasterService.findByPage(page, perPage);
        return rUtil.getInstance(0, pageResult, "查询成功!");
    }
}
