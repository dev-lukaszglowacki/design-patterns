package com.example.designpatterns.chainofresponsibility;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected String write(String message) {
        return "File::Logger: " + message;
    }
}
