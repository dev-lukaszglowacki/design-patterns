package com.example.designpatterns.visitor;

public class Mouse implements ComputerPart {
    @Override
    public String accept(ComputerPartVisitor computerPartVisitor) {
        return computerPartVisitor.visit(this);
    }
}
