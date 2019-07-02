package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;
import com.coding.sales.product.Product;

import java.math.BigDecimal;

/**
 * 打折
 */
public class PercentOff implements Discount {

    /**
     * 折扣率
     */
    private DiscountCard discountCard;

    public PercentOff(DiscountCard discountCard) {
        if (discountCard == null) {
            throw new RuntimeException("折扣卡不能为空");
        }
        BigDecimal discountRate = discountCard.getDiscountRate();
        // 等于0 则报错
        if (BigDecimal.ZERO.compareTo(discountRate) >= 1) {
            throw new RuntimeException("折扣率必须大于0");
        }
        BigDecimal discountRateOne = new BigDecimal(1);
        if (discountRateOne.compareTo(discountRate) > 1) {
            throw new RuntimeException("折扣率不能大于1");
        }
        this.discountCard = discountCard;
    }

    @Override
    public BigDecimal discount(OrderItem orderItem) {
        if (null == orderItem) {
            return BigDecimal.ZERO;
        }
        Product product = orderItem.getProduct();
        BigDecimal amount = orderItem.getAmount() == null ? BigDecimal.ZERO : orderItem.getAmount();
        if (null == product) {
            return BigDecimal.ZERO;
        }
        BigDecimal price = product.getPrice() == null ? BigDecimal.ZERO : product.getPrice();
        BigDecimal rate = new BigDecimal(1).subtract(discountCard.getDiscountRate());
        return price.multiply(amount).multiply(rate).setScale(2,  BigDecimal.ROUND_HALF_UP);
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }
}
