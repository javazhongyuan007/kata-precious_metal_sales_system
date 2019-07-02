package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;

import java.math.BigDecimal;

/**
 * 满3，第三件半价
 */
public class GiftWithPurchaseHalfOff extends AbstractDiscont {

    @Override
    public BigDecimal discount(OrderItem orderItem) {
        if (null == orderItem) {
            return BigDecimal.ZERO;
        }
        BigDecimal amount = orderItem.getAmount() == null ? BigDecimal.ZERO : orderItem.getAmount();
        BigDecimal threeItem = new BigDecimal(3);
        if (amount.compareTo(threeItem) >= 0) {
            BigDecimal price = orderItem.getProduct().getPrice() == null ? BigDecimal.ZERO : orderItem.getProduct().getPrice();
            return price.divide(new BigDecimal(2)).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}
