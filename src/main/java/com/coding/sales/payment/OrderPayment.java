package com.coding.sales.payment;

import com.coding.sales.order.Order;
import com.coding.sales.order.OrderStatus;

/**
 * 订单付款
 */
public class OrderPayment {

    /**
     * 订单
     */
    private Order order;

    private Payment payment;

    /**
     * 付款
     * @return
     */
    public boolean payment() {
        if (null == order) {
            throw new RuntimeException("订单不能为空！");
        }
        if (null == payment) {
            throw new RuntimeException("付款信息不能为空！");
        }
        if (order.getReceivables().compareTo(payment.getAmount()) > 0) {
            throw new RuntimeException("付款金额不能小于订单金额");
        }
        payment.payment();
        order.setOrderStatus(OrderStatus.PaymentCompleted);
        return true;
    }

}
