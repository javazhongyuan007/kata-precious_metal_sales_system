package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;
import com.coding.sales.product.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GiftWithPurchaseOneTest {

    @Test
    public void should_gift_one_when_by_four_product() {
        Discount discount = new GiftWithPurchaseOne();
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
        assertEquals(new BigDecimal(100.78), discount.discount(orderItem));

    }

    @Test
    public void should_gift_one_when_by_five_product() {
        Discount discount = new GiftWithPurchaseOne();
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
        Product product4 = new Product();
        product4.setProductNo("0001");
        product4.setProductName("产品1");
        product4.setPrice(new BigDecimal(100.78));
        product4.getDiscounts().add(discount);
        orderItem.addProduct(product);
        orderItem.addProduct(product1);
        orderItem.addProduct(product2);
        orderItem.addProduct(product3);
        orderItem.addProduct(product4);
        assertEquals(new BigDecimal(100.78), discount.discount(orderItem));

    }

}