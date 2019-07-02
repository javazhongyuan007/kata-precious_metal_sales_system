package com.coding.sales.discount;

import java.math.BigDecimal;

public class DiscountCard {

    private BigDecimal DiscountRate;
    private String DiscountName;

    public DiscountCard(String discountName,BigDecimal discountRate) {
        DiscountRate = discountRate;
        DiscountName = discountName;
    }


    public BigDecimal getDiscountRate() {
        return DiscountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        DiscountRate = discountRate;
    }

    public String getDiscountName() {
        return DiscountName;
    }

    public void setDiscountName(String discountName) {
        DiscountName = discountName;
    }

}
