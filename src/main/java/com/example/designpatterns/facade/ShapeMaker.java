package com.example.designpatterns.facade;

public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public String drawCircle(){
        return circle.draw();
    }
    public String drawRectangle(){
        return rectangle.draw();
    }
}
