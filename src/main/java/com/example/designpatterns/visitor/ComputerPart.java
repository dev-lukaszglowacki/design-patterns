package com.example.designpatterns.visitor;

public interface ComputerPart {
    String accept(ComputerPartVisitor computerPartVisitor);
}
