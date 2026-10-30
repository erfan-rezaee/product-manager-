package app;

import store.model.Order;
import store.service.OrderService;

public class Main {
    public static void main(String[] args){

        Order order = new Order("ORD-1001");

        Order.OrderItem item1 =
                new Order.OrderItem("Laptop", 85_000_000, 2);

        Order.OrderItem item2 =
                new Order.OrderItem("Mouse", 500_000, 1);

        System.out.println("========== Order Items ==========");
        order.addItem(item1);
        item1.showInfo();

        System.out.println();

        order.addItem(item2);
        item2.showInfo();
        System.out.println();

        Order.Receipt receipt = order.new Receipt();
        System.out.println("========== Receipt ==========");
        receipt.printReceipt();
        System.out.println();

        System.out.println("========== Order Service ==========");
        OrderService service = new OrderService();
        service.printOrder(order);
        System.out.println("==================================");
    }
}
