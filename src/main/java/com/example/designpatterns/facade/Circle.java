package com.example.designpatterns.facade;

public class Circle implements Shape {
    @Override
    public String draw() {
        return "Circle::draw()";
    }
}
