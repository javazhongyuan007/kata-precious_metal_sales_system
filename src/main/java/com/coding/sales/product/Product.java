package com.coding.sales.product;

import com.coding.sales.discount.Discount;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品
 */
public class Product {

    /**
     * 名称
     */
    private String productName;

    /**
     * 编号
     */
    private String productNo;

    /**
     * 单位
     */
    private String unit;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 商品活动
     */
    private List<Discount> discounts;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
