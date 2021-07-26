package com.sise.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sise.utils.DateToStringSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private Long detailId;

    private Long orderId;

    private Long menuId;

    private String menuName;

    private BigDecimal menuPrice;

    private Integer menuQuantity;

    private String menuIcon;

    @JsonSerialize(using = DateToStringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToStringSerializer.class)
    private Date updateTime;

    private Byte status;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public BigDecimal getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(BigDecimal menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Integer getMenuQuantity() {
        return menuQuantity;
    }

    public void setMenuQuantity(Integer menuQuantity) {
        this.menuQuantity = menuQuantity;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailId=").append(detailId);
        sb.append(", orderId=").append(orderId);
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuPrice=").append(menuPrice);
        sb.append(", menuQuantity=").append(menuQuantity);
        sb.append(", menuIcon=").append(menuIcon);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}