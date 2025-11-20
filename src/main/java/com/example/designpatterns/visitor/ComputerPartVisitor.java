package com.example.designpatterns.visitor;

public interface ComputerPartVisitor {
    String visit(Computer computer);
    String visit(Mouse mouse);
    String visit(Keyboard keyboard);
    String visit(Monitor monitor);
}
