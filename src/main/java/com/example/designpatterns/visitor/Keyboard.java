package com.example.designpatterns.visitor;

public class Keyboard implements ComputerPart {
    @Override
    public String accept(ComputerPartVisitor computerPartVisitor) {
        return computerPartVisitor.visit(this);
    }
}
