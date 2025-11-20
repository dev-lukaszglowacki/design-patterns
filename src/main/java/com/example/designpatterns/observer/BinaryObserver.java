package com.example.designpatterns.observer;

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public String update() {
        return "Binary String: " + Integer.toBinaryString(subject.getState());
    }
}
