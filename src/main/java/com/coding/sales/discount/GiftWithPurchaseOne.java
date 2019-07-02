package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;

import java.math.BigDecimal;

/**
 * 满4赠一
 */
public class GiftWithPurchaseOne extends AbstractDiscont {
    @Override
    public BigDecimal discount(OrderItem orderItem) {
        if (null == orderItem) {
            return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        BigDecimal amount = orderItem.getAmount() == null ? BigDecimal.ZERO : orderItem.getAmount();
        BigDecimal fourItem = new BigDecimal(4);
        if (amount.compareTo(fourItem) >= 0) {
            BigDecimal price = orderItem.getProduct().getPrice() == null ? BigDecimal.ZERO : orderItem.getProduct().getPrice();
            return price;
        }
        return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
