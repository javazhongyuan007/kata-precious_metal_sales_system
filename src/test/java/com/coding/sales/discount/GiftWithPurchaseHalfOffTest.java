package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;
import com.coding.sales.product.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GiftWithPurchaseHalfOffTest {

    @Test
    public void should_half_off_when_by_three_product() {
        Discount discount = new GiftWithPurchaseHalfOff();
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setProductNo("0001");
        product.setProductName("产品1");
        product.setPrice(new BigDecimal(100.78));
        product.getDiscounts().add(discount);
        Product product1 = new Product();
        product1.setProductNo("0001");
        product1.setProductName("产品1");
        product1.setPrice(new BigDecimal(100.78));
        product1.getDiscounts().add(discount);
        Product product2 = new Product();
        product2.setProductNo("0001");
        product2.setProductName("产品1");
        product2.setPrice(new BigDecimal(100.78));
        product2.getDiscounts().add(discount);
        orderItem.addProduct(product);
        orderItem.addProduct(product1);
        orderItem.addProduct(product2);
        assertEquals((new BigDecimal(100.78)).divide(new BigDecimal(2)).setScale(2,  BigDecimal.ROUND_HALF_UP), discount.discount(orderItem));
    }

    @Test
    public void should_half_off_when_by_four_product() {
        Discount discount = new GiftWithPurchaseHalfOff();
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setProductNo("0001");
        product.setProductName("产品1");
        product.setPrice(new BigDecimal(100.78));
        product.getDiscounts().add(discount);
        Product product1 = new Product();
        product1.setProductNo("0001");
        product1.setProductName("产品1");
        product1.setPrice(new BigDecimal(100.78));
        product1.getDiscounts().add(discount);
        Product product2 = new Product();
        product2.setProductNo("0001");
        product2.setProductName("产品1");
        product2.setPrice(new BigDecimal(100.78));
        product2.getDiscounts().add(discount);
        Product product3 = new Product();
        product3.setProductNo("0001");
        product3.setProductName("产品1");
        product3.setPrice(new BigDecimal(100.78));
        product3.getDiscounts().add(discount);
        orderItem.addProduct(product);
        orderItem.addProduct(product1);
        orderItem.addProduct(product2);
        orderItem.addProduct(product3);
        assertEquals((new BigDecimal(100.78)).divide(new BigDecimal(2)).setScale(2,  BigDecimal.ROUND_HALF_UP), discount.discount(orderItem));
    }
    @Test
    public void should_not_half_off_when_buy_two_product() {
        Discount discount = new GiftWithPurchaseHalfOff();
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setProductNo("0001");
        product.setProductName("产品1");
        product.setPrice(new BigDecimal(100.78));
        product.getDiscounts().add(discount);
        Product product1 = new Product();
        product1.setProductNo("0001");
        product1.setProductName("产品1");
        product1.setPrice(new BigDecimal(100.78));
        product1.getDiscounts().add(discount);
        orderItem.addProduct(product);
        orderItem.addProduct(product1);
        assertEquals((new BigDecimal(0)).setScale(2,  BigDecimal.ROUND_HALF_UP), discount.discount(orderItem));
    }

}