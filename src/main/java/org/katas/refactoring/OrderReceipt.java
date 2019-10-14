package org.katas.refactoring;

public class OrderReceipt {
    private Order orderList;
    private Character NEW_TAB = '\t';
    private Character NEW_LINE = '\n';
    private String TOP_RECEIPT = "======Printing Orders======" + NEW_LINE;
    private double totalSalesTax = 0d;
    private double total = 0d;
    private double computedSalesTax = 0d;
    StringBuilder output = new StringBuilder();

    public OrderReceipt(Order orderList) {
        this.orderList = orderList;
    }

    public String printReceipt() {
        output.append(TOP_RECEIPT);
        output.append(orderList.getCustomerName());
        output.append(orderList.getCustomerAddress());
        appendPrintInformation(orderList);
        output.append("Sales Tax").append(NEW_TAB).append(totalSalesTax);
        output.append("Total Amount").append(NEW_TAB).append(total);
        return output.toString();
    }

    private double getComputedSalesTax(OrderItems orderItems) {
        return orderItems.totalAmount() * .10;
    }

    private double getTotalAmount(double total, OrderItems orderItems, double computedSalesTax) {
        total = getTotal(total, orderItems, computedSalesTax);
        return total;
    }

    private double getTotal(double total, OrderItems orderItems, double computedSalesTax) {
        total += orderItems.totalAmount() + computedSalesTax;
        return total;
    }

    private void appendPrintInformation(Order orders) {
        for (OrderItems orderItems : orders.getLineItems()) {
            output.append(orderItems.getDescription());
            output.append(NEW_TAB);
            output.append(orderItems.getPrice());
            output.append(NEW_TAB);
            output.append(orderItems.getQuantity());
            output.append(NEW_TAB);
            output.append(orderItems.totalAmount());
            output.append(NEW_LINE);
            computedSalesTax = getComputedSalesTax(orderItems);
            totalSalesTax += computedSalesTax;

            total = getTotalAmount(total, orderItems, computedSalesTax);
        }
    }
}