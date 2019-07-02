package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;
import java.math.BigDecimal;

/**
 * 活动
 */
public interface Discount {

    /**
     * 折扣
     * @return 折扣金额
     */
    BigDecimal discount(OrderItem orderItem);

    /**
     * 折扣卡
     * @return
     */
    DiscountCard getDiscountCard();

}
