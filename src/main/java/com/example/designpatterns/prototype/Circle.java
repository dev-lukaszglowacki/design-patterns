package com.example.designpatterns.prototype;

public class Circle extends Shape {
    public Circle(){
        type = "Circle";
    }

    @Override
    public String toString() {
        return "Circle object";
    }
}
