package com.example.designpatterns.command;

public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public String buy(){
        return "Stock [ Name: "+name+", Quantity: " + quantity +" ] bought";
    }
    public String sell(){
        return "Stock [ Name: "+name+", Quantity: " + quantity +" ] sold";
    }
}
