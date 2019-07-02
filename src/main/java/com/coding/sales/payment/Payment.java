package com.coding.sales.payment;

import java.math.BigDecimal;

public class Payment {

    private String type;
    private BigDecimal amount;

    /**
     * 付款
     * @return
     */
    public boolean payment(){
//        throw new RuntimeException("调用支付系统失败！");
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
