package com.example.designpatterns.factory;

import org.springframework.stereotype.Component;

@Component("Circle")
public class Circle implements Shape {

    @Override
    public String draw() {
        return "Drawing a Circle";
    }
}
