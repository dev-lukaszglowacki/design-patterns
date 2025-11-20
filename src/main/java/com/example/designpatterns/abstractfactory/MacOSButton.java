package com.example.designpatterns.abstractfactory;

public class MacOSButton implements Button {
    @Override
    public String paint() {
        return "Painting a MacOS button";
    }
}
