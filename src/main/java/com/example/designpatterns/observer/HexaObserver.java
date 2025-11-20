package com.example.designpatterns.observer;

public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public String update() {
        return "Hex String: " + Integer.toHexString(subject.getState()).toUpperCase();
    }
}
