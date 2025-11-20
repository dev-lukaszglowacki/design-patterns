package com.example.designpatterns.visitor;

public class Monitor implements ComputerPart {
    @Override
    public String accept(ComputerPartVisitor computerPartVisitor) {
        return computerPartVisitor.visit(this);
    }
}
