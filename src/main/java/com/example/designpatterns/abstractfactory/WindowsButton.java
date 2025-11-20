package com.example.designpatterns.abstractfactory;

public class WindowsButton implements Button {
    @Override
    public String paint() {
        return "Painting a Windows button";
    }
}
