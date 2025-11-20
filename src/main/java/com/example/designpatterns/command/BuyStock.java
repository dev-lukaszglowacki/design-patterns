package com.example.designpatterns.command;

public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public String execute() {
        return abcStock.buy();
    }
}
