package com.example.designpatterns.strategy;

import org.springframework.stereotype.Component;

@Component("CreditCard")
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    @Override
    public String pay(int amount) {
        return amount + " paid with credit card";
    }
}
