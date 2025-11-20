package com.example.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public List<String> notifyAllObservers() {
        List<String> result = new ArrayList<>();
        for (Observer observer : observers) {
            result.add(observer.update());
        }
        return result;
    }
}
