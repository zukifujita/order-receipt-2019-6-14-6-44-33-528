package org.katas.refactoring;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<OrderItems> orderLists;

    public Order(String name, String address, List<OrderItems> orderLists) {
        this.name = name;
        this.address = address;
        this.orderLists = orderLists;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<OrderItems> getLineItems() {
        return orderLists;
    }
}
