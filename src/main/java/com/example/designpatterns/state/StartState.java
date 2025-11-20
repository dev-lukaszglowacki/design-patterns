package com.example.designpatterns.state;

public class StartState implements State {
    @Override
    public String doAction(Context context) {
        context.setState(this);
        return "Player is in start state";
    }

    public String toString(){
        return "Start State";
    }
}
