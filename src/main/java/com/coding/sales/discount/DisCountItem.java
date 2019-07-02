package com.coding.sales.discount;

import com.coding.sales.product.Product;

import java.math.BigDecimal;

/**
 * 优惠明细
 */
public class DisCountItem {
    /**
     * 优惠商品
     */
    private Product product;
    /**
     * 优惠金额
     */
    private BigDecimal discount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
