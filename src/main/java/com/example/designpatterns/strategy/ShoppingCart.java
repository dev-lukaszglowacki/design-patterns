package com.example.designpatterns.strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String checkout(int amount) {
        if (paymentStrategy == null) {
            return "No payment strategy set.";
        }
        return paymentStrategy.pay(amount);
    }
}
