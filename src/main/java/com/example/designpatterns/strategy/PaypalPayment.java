package com.example.designpatterns.strategy;

import org.springframework.stereotype.Component;

@Component("Paypal")
public class PaypalPayment implements PaymentStrategy {
    private String emailId;

    @Override
    public String pay(int amount) {
        return amount + " paid using Paypal";
    }
}
