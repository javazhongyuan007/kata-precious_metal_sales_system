package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 满减
 */
public class InstantRebate extends AbstractDiscont {

    private BigDecimal instantRebateMoney;
    private BigDecimal totalMoney;

    public InstantRebate(BigDecimal instantRebateMoney, BigDecimal totalMoney) {
        if (null == instantRebateMoney) {
            throw new RuntimeException("满减金额有误");
        }
        if (null == totalMoney) {
            throw new RuntimeException("满减阈值金额有误");
        }
        this.instantRebateMoney = instantRebateMoney;
        this.totalMoney = totalMoney;
    }

    @Override
    public BigDecimal discount(OrderItem orderItem) {
        if (orderItem == null) {
            return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        BigDecimal subTotal = orderItem.getSubTotal() == null ? BigDecimal.ZERO : orderItem.getSubTotal();
        BigDecimal temp = BigDecimal.ZERO;
        if (subTotal.compareTo(totalMoney) >= 0) {
            return instantRebateMoney.setScale(2,  BigDecimal.ROUND_HALF_UP);
        }
        return BigDecimal.ZERO.setScale(2,  BigDecimal.ROUND_HALF_UP);
    }
}
