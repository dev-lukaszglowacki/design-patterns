package com.example.designpatterns.command;

public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public String execute() {
        return abcStock.sell();
    }
}
