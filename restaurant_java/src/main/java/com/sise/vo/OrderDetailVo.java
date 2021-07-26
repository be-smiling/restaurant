package com.sise.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sise.entity.OrderDetail;
import com.sise.utils.DateToStringSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单主类包含订单详情类的实体
 */
public class OrderDetailVo {

    private Long orderId;

    private String orderNumber;

    private String userName;

    private String userPhone;

    private String userAddress;

    private String userOpenid;

    private BigDecimal orderAmount;

    private String orderRestaurant;

    private Byte orderStatus;

    private Byte payStatus;

    @JsonSerialize(using = DateToStringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToStringSerializer.class)
    private Date updateTime;

    private Byte status;

    private List<OrderDetail> orderDetailList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderRestaurant() {
        return orderRestaurant;
    }

    public void setOrderRestaurant(String orderRestaurant) {
        this.orderRestaurant = orderRestaurant;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", userName=").append(userName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", userOpenid=").append(userOpenid);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", orderRestaurant=").append(orderRestaurant);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", orderDetailList=").append(orderDetailList);
        sb.append("]");
        return sb.toString();
    }
}
