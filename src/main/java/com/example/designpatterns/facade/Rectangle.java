package com.example.designpatterns.facade;

public class Rectangle implements Shape {
    @Override
    public String draw() {
        return "Rectangle::draw()";
    }
}
