package com.coding.sales.discount;

import com.coding.sales.order.OrderItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 满减
 */
public class InstantRebate extends AbstractDiscont {

    private Map<BigDecimal, BigDecimal> instantRebateMap = new HashMap<BigDecimal, BigDecimal>();
    {
        instantRebateMap.put(new BigDecimal(3000.00), new BigDecimal(350.00));
        instantRebateMap.put(new BigDecimal(2000.00), new BigDecimal(30.00));
        instantRebateMap.put(new BigDecimal(1000.00), new BigDecimal(10.00));
    }


    @Override
    public BigDecimal discount(OrderItem orderItem) {
        if (orderItem == null) {
            return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        BigDecimal subTotal = orderItem.getSubTotal() == null ? BigDecimal.ZERO : orderItem.getSubTotal();
        BigDecimal instantRebateMoney = BigDecimal.ZERO;
        BigDecimal temp = BigDecimal.ZERO;
        for (BigDecimal decimal : instantRebateMap.keySet()) {
            if (subTotal.compareTo(decimal) > 0) {
                temp = instantRebateMap.get(decimal);
                if (temp.compareTo(instantRebateMoney) > 0) {
                    instantRebateMoney = temp;
                }
            }
        }
        return instantRebateMoney.setScale(2,  BigDecimal.ROUND_HALF_UP);
    }
}
