package com.example.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public List<String> placeOrders(){
        List<String> results = new ArrayList<>();
        for (Order order : orderList) {
            results.add(order.execute());
        }
        orderList.clear();
        return results;
    }
}
