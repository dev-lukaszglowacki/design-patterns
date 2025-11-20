package com.example.designpatterns.state;

public class StopState implements State {
    @Override
    public String doAction(Context context) {
        context.setState(this);
        return "Player is in stop state";
    }

    public String toString(){
        return "Stop State";
    }
}
