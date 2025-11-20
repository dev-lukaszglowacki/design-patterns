package com.example.designpatterns.visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public String visit(Computer computer) {
        return "Displaying Computer.";
    }

    @Override
    public String visit(Mouse mouse) {
        return "Displaying Mouse.";
    }

    @Override
    public String visit(Keyboard keyboard) {
        return "Displaying Keyboard.";
    }

    @Override
    public String visit(Monitor monitor) {
        return "Displaying Monitor.";
    }
}
