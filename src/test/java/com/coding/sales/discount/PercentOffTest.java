package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;
import com.coding.sales.product.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PercentOffTest {

    @Test
    public void should_20_when_buy400_95_off() {
        DiscountCard discountCard = new DiscountCard("9.5折", new BigDecimal(0.95));
        Discount discount = new PercentOff(discountCard);
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setProductNo("0001");
        product.setProductName("产品1");
        product.setPrice(new BigDecimal(100.00));
        product.getDiscounts().add(discount);
        Product product1 = new Product();
        product1.setProductNo("0001");
        product1.setProductName("产品1");
        product1.setPrice(new BigDecimal(100.00));
        product1.getDiscounts().add(discount);
        Product product2 = new Product();
        product2.setProductNo("0001");
        product2.setProductName("产品1");
        product2.setPrice(new BigDecimal(100.00));
        product2.getDiscounts().add(discount);
        Product product3 = new Product();
        product3.setProductNo("0001");
        product3.setProductName("产品1");
        product3.setPrice(new BigDecimal(100.00));
        product3.getDiscounts().add(discount);
        orderItem.addProduct(product);
        orderItem.addProduct(product1);
        orderItem.addProduct(product2);
        orderItem.addProduct(product3);
        assertEquals(new BigDecimal(20).setScale(2, BigDecimal.ROUND_HALF_UP), discount.discount(orderItem));
    }
    public void should_0_when_buy400_not_95_off() {
        DiscountCard discountCard = new DiscountCard("9.5折", new BigDecimal(0.95));
        Discount discount = new PercentOff(discountCard);
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setProductNo("0001");
        product.setProductName("产品1");
        product.setPrice(new BigDecimal(100.00));
        Product product1 = new Product();
        product1.setProductNo("0001");
        product1.setProductName("产品1");
        product1.setPrice(new BigDecimal(100.00));
        Product product2 = new Product();
        product2.setProductNo("0001");
        product2.setProductName("产品1");
        product2.setPrice(new BigDecimal(100.00));
        Product product3 = new Product();
        product3.setProductNo("0001");
        product3.setProductName("产品1");
        product3.setPrice(new BigDecimal(100.00));
        orderItem.addProduct(product);
        orderItem.addProduct(product1);
        orderItem.addProduct(product2);
        orderItem.addProduct(product3);
        assertEquals(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP), discount.discount(orderItem));
    }

}