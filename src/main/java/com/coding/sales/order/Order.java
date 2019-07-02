package com.coding.sales.order;

import com.coding.sales.discount.Discount;
import com.coding.sales.discount.DiscountItem;
import com.coding.sales.member.Member;
import com.coding.sales.product.Product;
import org.mockito.internal.matchers.Or;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;
    /**
     * 优惠明细
     */
    private List<DiscountItem> discountItems = new ArrayList<DiscountItem>();
    /**
     * 优惠总金额
     */
    private BigDecimal totalDiscountPrice;
    /**
     * 应收总金额
     */
    private BigDecimal receivables;

    /**
     * 新增商品
     * @param product
     */
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (product.getProductNo() == null || "".equals(product.getProductNo())) {
            throw new RuntimeException("新增的产品编号不能为空");
        }
        int addOrderItemIndex = 0;
        OrderItem tempOrderItem = null;
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().getProductNo().equalsIgnoreCase(product.getProductNo())) {
                orderItem.addProduct(product);
                tempOrderItem = orderItem;
                break;
            }
            addOrderItemIndex += 1;
        }
        // 没有该商品
        if (addOrderItemIndex >= orderItems.size()) {
            OrderItem orderItem = new OrderItem();
            orderItem.addProduct(product);
            tempOrderItem = orderItem;
            orderItems.add(orderItem);
        }

        // 获取该产品的优惠信息
        int addDiscountItemIndex = 0;
        for (DiscountItem disCountItem : discountItems) {
            if (disCountItem.getProduct().getProductNo().equalsIgnoreCase(product.getProductNo())) {
                break;
            }
            addDiscountItemIndex += 1;
        }
        //
        if (addDiscountItemIndex >= discountItems.size()) {
            discountItems.add(getDiscountMoney(tempOrderItem));
        } else {
            discountItems.set(addDiscountItemIndex, getDiscountMoney(tempOrderItem));
        }
    }

    /**
     * 获取优惠金额
     * @param orderItem
     * @return
     */
    public DiscountItem getDiscountMoney(OrderItem orderItem) {
        DiscountItem discountItem = new DiscountItem();
        BigDecimal discountMoney = BigDecimal.ZERO;
        BigDecimal tempDiscountMoney = BigDecimal.ZERO;
        for (Discount discount : orderItem.getProduct().getDiscounts()) {
            tempDiscountMoney = discount.discount(orderItem);
            if (tempDiscountMoney.compareTo(discountMoney) > 0) {
                discountMoney = tempDiscountMoney;
                discountItem.setDiscountCard(discount.getDiscountCard());
            }
        }
        discountItem.setProduct(orderItem.getProduct());
        discountItem.setDiscount(discountMoney);
        return discountItem;
    }

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

    public List<DiscountItem> getDiscountItems() {
        return discountItems;
    }

    public void setDiscountItems(List<DiscountItem> discountItems) {
        this.discountItems = discountItems;
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
