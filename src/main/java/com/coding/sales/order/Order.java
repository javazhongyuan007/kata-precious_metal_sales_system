package com.coding.sales.order;

import com.coding.sales.discount.DisCountItem;
import com.coding.sales.member.Member;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Order {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 会员
     */
    private Member member;
    /**
     * 订单明细
     */
    private List<OrderItem> orderItems;
    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;
    /**
     * 优惠明细
     */
    private List<DisCountItem> disCountItems;
    /**
     * 优惠总金额
     */
    private BigDecimal totalDiscountPrice;
    /**
     * 应收总金额
     */
    private BigDecimal receivables;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<DisCountItem> getDisCountItems() {
        return disCountItems;
    }

    public void setDisCountItems(List<DisCountItem> disCountItems) {
        this.disCountItems = disCountItems;
    }

    public BigDecimal getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public void setTotalDiscountPrice(BigDecimal totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public BigDecimal getReceivables() {
        return receivables;
    }

    public void setReceivables(BigDecimal receivables) {
        this.receivables = receivables;
    }
}
