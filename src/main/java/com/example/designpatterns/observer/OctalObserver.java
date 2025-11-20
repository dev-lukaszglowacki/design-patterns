package com.example.designpatterns.observer;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public String update() {
        return "Octal String: " + Integer.toOctalString(subject.getState());
    }
}
