package com.coding.sales.representation;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* 打印格式
方鼎银行贵金属购买凭证

销售单号：0000001 日期：2019-11-11 23:00:00
客户卡号：6236609999 会员姓名：马丁 客户等级：XXXX  累计积分：XXXX

商品及数量           单价         金额
(001001)世园会五十国钱币册x 2,998.00,1996.00
(001002)2019北京世园会纪念银章大全40g x 3, 1380.00,4140.00
(002002)中国经典钱币套装x 1, 1500.00,1500.00
(002003)中国银象棋32gx 2, 2200.00,4400.00
合计：12036.00

优惠清单：#如果有优惠，则打印
 (001002)2019北京世园会纪念银章大全:-138.00
(002002)中国经典钱币套装:-10.00
(002003)中国银象棋:-2420.00
优惠合计：2568.00 #如果有优惠，则打印

应收合计：9468.00
收款：
 9折打折券 x 1
 账户余额：9408.00元
客户等级与积分：#每一项有变化时才打印
 新增积分：9408
 恭喜您升级为金卡客户！
*/

public class OrderRepresentation {
    private String orderId;
    private Date createTime;
    private String memberNo;
    private String memberName;
    private String oldMemberType;
    private String newMemberType;
    private int memberPointsIncreased;
    private int memberPoints;
    private List<OrderItemRepresentation> items;
    private BigDecimal totalPrice;
    private List<DiscountItemRepresentation> discounts;
    private BigDecimal totalDiscountPrice;
    private BigDecimal receivables;
    private List<PaymentRepresentation> payments;
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("0.00");

    /**
     * @param orderId            订单号
     * @param createTime         订单创建时间
     * @param memberNo           会员编号
     * @param memberName         会员姓名
     * @param oldMemberType      原会员等级
     * @param newMemberType      新会员等级。当新老等级不一致时，视为升级
     * @param memberPointsIncreased    本次消费会员新增的积分
     * @param memberPoints       会员最新的积分( = 老积分 + memberPointsIncreased)
     * @param orderItems         订单明细
     * @param totalPrice         订单总金额
     * @param discounts          优惠明细
     * @param totalDiscountPrice 优惠总金额
     * @param receivables        应收金额
     * @param payments           付款记录
     */
    public OrderRepresentation(String orderId, Date createTime,
                               String memberNo, String memberName, String oldMemberType, String newMemberType, int memberPointsIncreased, int memberPoints,
                               List<OrderItemRepresentation> orderItems,
                               BigDecimal totalPrice, List<DiscountItemRepresentation> discounts, BigDecimal totalDiscountPrice,
                               BigDecimal receivables, List<PaymentRepresentation> payments) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.oldMemberType = oldMemberType;
        this.newMemberType = newMemberType;
        this.memberPointsIncreased = memberPointsIncreased;
        this.memberPoints = memberPoints;
        this.items = orderItems == null ? new ArrayList<OrderItemRepresentation>() : orderItems;
        this.totalPrice = totalPrice == null ? BigDecimal.ZERO : totalPrice;
        this.discounts = discounts == null ? new ArrayList<DiscountItemRepresentation>() : discounts;
        this.totalDiscountPrice = totalDiscountPrice == null ? BigDecimal.ZERO : totalDiscountPrice;
        this.receivables = receivables == null ? BigDecimal.ZERO : receivables;
        this.payments = payments == null ? new ArrayList<PaymentRepresentation>() : payments;
    }

    private boolean isBigDecimalEquals(BigDecimal value1, BigDecimal value2) {
        if (value1 == null && value1 == null) {
            return true;
        }

        if (value1 == null && value2 != null) {
            return false;
        }

        if (value1 != null && value2 == null) {
            return false;
        }

        return value1.compareTo(value2) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepresentation that = (OrderRepresentation) o;
        boolean result = memberPoints == that.memberPoints &&
                memberPointsIncreased == that.memberPointsIncreased &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(memberNo, that.memberNo) &&
                oldMemberType == that.oldMemberType &&
                newMemberType == that.newMemberType &&
                Objects.equals(items, that.items) &&
                Objects.equals(memberName, that.memberName) &&
                Objects.equals(discounts, that.discounts) &&
                Objects.equals(payments, that.payments) &&
                isBigDecimalEquals(totalPrice, that.totalPrice) &&
                isBigDecimalEquals(totalDiscountPrice, that.totalDiscountPrice) &&
                isBigDecimalEquals(receivables, that.receivables);

        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createTime, memberNo, memberName, oldMemberType, newMemberType, memberPoints,
                items, totalPrice, discounts, totalDiscountPrice, receivables, payments, memberPointsIncreased);
    }

    @Override
    public String toString() {
        return getReportTitle() + getOrderDetail() + getDiscount() + getPayment() + getMemberChangeInfo();
    }

    private String getReportTitle() {
        String reportTitle = "方鼎银行贵金属购买凭证\n" +
                "\n" +
                "销售单号：%s 日期：%s \n" +
                "客户卡号：%s 会员姓名：%s 客户等级：%s 累计积分：%d \n" +
                "\n" +
                "商品及数量           单价         金额\n";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return String.format(reportTitle, orderId, dateFormat.format(createTime), memberNo, memberName, newMemberType, memberPoints);
    }

    private String getOrderDetail() {
        StringBuilder result = new StringBuilder();
        for (OrderItemRepresentation item : items) {
            result.append(String.format("(%s)%sx%s %s, %s\n",
                    item.getProductNo(),
                    item.getProductName(),
                    item.getCount().toString(),
                    MONEY_FORMAT.format(item.getPrice()),
                    MONEY_FORMAT.format(item.getSubTotal())));
        }
        result.append(String.format("合计：%s\n", MONEY_FORMAT.format(totalPrice)));

        return result.toString();
    }

    private String getDiscount() {
        StringBuilder result = new StringBuilder("\n优惠清单：\n");
        for (DiscountItemRepresentation discount : discounts) {
            result.append(String.format(" (%s)%s: -%s\n",
                    discount.getProductNo(),
                    discount.getProductName(),
                    MONEY_FORMAT.format(discount.getDiscount())));
        }
        result.append(String.format("优惠合计：%s\n", MONEY_FORMAT.format(totalDiscountPrice)));

        return result.toString();
    }

    private String getPayment() {
        StringBuilder result = new StringBuilder(String.format("\n应收合计：%s\n收款：\n", MONEY_FORMAT.format(receivables)));
        for (PaymentRepresentation paymentRepresentation : payments) {
            result.append(String.format(" %s：%s\n",
                    paymentRepresentation.getType(),
                    MONEY_FORMAT.format(paymentRepresentation.getAmount())));
        }

        return result.toString();
    }

    private String getMemberChangeInfo() {
        StringBuilder result = new StringBuilder();
        if (memberNo == null || memberNo.length() <= 0) {
            return "";
        }

        result.append("客户等级与积分：\n");
        result.append(String.format(" 新增积分：%d \n", memberPointsIncreased));
        if (!newMemberType.equals(oldMemberType)) {
            result.append(String.format(" 恭喜您升级为%s客户！\n", newMemberType));
        }

        return result.toString();
    }
}