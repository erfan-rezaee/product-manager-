package store.service;

import store.model.Order;

public class OrderService {

    public void printOrder(Order order){

        System.out.println("Order ID: " + order.getOrderId());
        System.out.printf("Total Price: %.1f%n" , order.getTotalPrice());
    }
}
