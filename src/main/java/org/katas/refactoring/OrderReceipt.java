package org.katas.refactoring;

public class OrderReceipt {
    private Order orderList;

    public OrderReceipt(Order orderList) {
        this.orderList = orderList;
    }

    public String printReceipt() {
        Character newTab = '\t';
        Character newLine = '\n';
        String topReceipt = "======Printing Orders======" + newLine;

        StringBuilder output = new StringBuilder();

        output.append(topReceipt);

        output.append(orderList.getCustomerName());
        output.append(orderList.getCustomerAddress());

        double totalSalesTax = 0d;
        double total = 0d;
        for (OrderItems orderItems : orderList.getLineItems()) {
            output.append(orderItems.getDescription());
            output.append(newTab);
            output.append(orderItems.getPrice());
            output.append(newTab);
            output.append(orderItems.getQuantity());
            output.append(newTab);
            output.append(orderItems.totalAmount());
            output.append(newLine);

            double computedSalesTax = getComputedSalesTax(orderItems);
            totalSalesTax += computedSalesTax;

            total = getTotalAmount(total, orderItems, computedSalesTax);
        }

        output.append("Sales Tax").append(newTab).append(totalSalesTax);

        output.append("Total Amount").append(newTab).append(total);
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
}