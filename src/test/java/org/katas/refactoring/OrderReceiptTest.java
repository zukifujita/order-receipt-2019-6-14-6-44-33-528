package org.katas.refactoring;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


public class OrderReceiptTest {
    @Test
    public void should_print_customer_information_on_order() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output).contains("Mr X", "Chicago, 60601");
    }

    @Test
    public void should_print_line_item_and_sales_tax_information() {
        ArrayList<OrderItems> orderLists = new ArrayList<OrderItems>() {{
            add(new OrderItems("milk", 10.0, 2));
            add(new OrderItems("biscuits", 5.0, 5));
            add(new OrderItems("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, orderLists));

        String output = receipt.printReceipt();

        assertThat(output).contains(
                "milk\t10.0\t2\t20.0\n",
                "biscuits\t5.0\t5\t25.0\n",
                "chocolate\t20.0\t1\t20.0\n",
                "Sales Tax\t6.5",
                "Total Amount\t71.5"
        );
    }

}
