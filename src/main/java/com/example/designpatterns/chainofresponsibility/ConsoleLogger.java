package com.example.designpatterns.chainofresponsibility;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected String write(String message) {
        return "Standard Console::Logger: " + message;
    }
}
