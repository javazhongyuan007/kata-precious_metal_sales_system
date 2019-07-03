package com.coding.sales;

import com.coding.sales.data.MembersData;
import com.coding.sales.data.ProductData;
import com.coding.sales.discount.DiscountItem;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.member.Member;
import com.coding.sales.order.Order;
import com.coding.sales.order.OrderItem;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;
import com.coding.sales.payment.OrderPayment;
import com.coding.sales.payment.Payment;
import com.coding.sales.product.Product;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);

        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //1.转换 OrderCommand 为订单类
        Order order = new Order();
        order.setOrderId(command.getOrderId());
        try {
            order.setCreateTime(dateFormat.parse(command.getCreateTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> discounts = command.getDiscounts();
        order.setCoupons(discounts);
        order.setMember(MembersData.memberMap.get(command.getMemberId()));
        List<OrderItemCommand> items = command.getItems();
        List<PaymentCommand> payments = command.getPayments();
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItemCommand item : items) {
            for (int i = 0; i < item.getAmount().setScale(0, BigDecimal.ROUND_DOWN).intValue(); i++) {
                order.addProduct(ProductData.productMap.get(item.getProduct()));
            }
        }
        Payment payment = new Payment();
        for (PaymentCommand paymentCommand : payments) {
            payment.setType(paymentCommand.getType());
            payment.setAmount(paymentCommand.getAmount());
        }
        OrderPayment orderPayment = new OrderPayment( order, payment);
        orderPayment.payment();
        List<OrderItemRepresentation> orderItemsReturn = new ArrayList<OrderItemRepresentation>();
        for (OrderItem orderItem : order.getOrderItems()) {
            OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(orderItem.getProduct().getProductNo(), orderItem.getProduct().getProductName(), orderItem.getProduct().getPrice(), orderItem.getAmount(), orderItem.getSubTotal());
            orderItemsReturn.add(orderItemRepresentation);
        }
        List<DiscountItemRepresentation> discountsReturn = new ArrayList<DiscountItemRepresentation>();
        for (DiscountItem discountItem : order.getDiscountItems()) {
            DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(discountItem.getProduct().getProductNo(), discountItem.getProduct().getProductName(), discountItem.getDiscount());
            discountsReturn.add(discountItemRepresentation);
        }

        List<PaymentRepresentation> paymentsReturn = new ArrayList<PaymentRepresentation>();
        PaymentRepresentation paymentRepresentation = new PaymentRepresentation(payment.getType(), payment.getAmount());
        paymentsReturn.add(paymentRepresentation);
        result = new OrderRepresentation(order.getOrderId(), order.getCreateTime(), order.getMember().getMemberNo(), order.getMember().getMemberName(), order.getMember().getOldMemberType().getName(), order.getMember().getNewMemberType().getName(), order.getMember().getMemberPointsIncreased(), order.getMember().getMemberPoints(),
                orderItemsReturn, order.getTotalPrice(), discountsReturn, order.getTotalDiscountPrice(),
                order.getReceivables(), paymentsReturn, order.getCoupons());
        return result;
    }
}
