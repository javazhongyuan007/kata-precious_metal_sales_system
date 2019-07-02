package com.coding.sales.order;

import com.coding.sales.product.Product;

import java.math.BigDecimal;

/**
 * 订单明细
 */
public class OrderItem {
    /**
     * 商品
     */
    private Product product;
    /**
     * 数量
     */
    private BigDecimal amount;
    /**
     * 小计
     */
    private BigDecimal subTotal;

    public OrderItem() {
        amount = BigDecimal.ZERO;
        subTotal = BigDecimal.ZERO;
    }

    /**
     * 新增商品
     * @param product
     */
    public void addProduct(Product product) {
        amount = amount.add(new BigDecimal(1));
        subTotal = subTotal.add(product.getPrice());
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
