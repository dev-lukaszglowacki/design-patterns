package com.example.designpatterns.factory;

import org.springframework.stereotype.Component;

@Component("Rectangle")
public class Rectangle implements Shape {

    @Override
    public String draw() {
        return "Drawing a Rectangle";
    }
}
