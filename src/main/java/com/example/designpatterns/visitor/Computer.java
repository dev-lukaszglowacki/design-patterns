package com.example.designpatterns.visitor;

public class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public String accept(ComputerPartVisitor computerPartVisitor) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            result.append(parts[i].accept(computerPartVisitor)).append(" | ");
        }
        result.append(computerPartVisitor.visit(this));
        return result.toString();
    }
}
