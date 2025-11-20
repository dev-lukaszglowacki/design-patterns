package com.example.designpatterns.templatemethod;

public abstract class Game {
    abstract String initialize();
    abstract String startPlay();
    abstract String endPlay();

    public final String play(){
        String result = initialize();
        result += " | " + startPlay();
        result += " | " + endPlay();
        return result;
    }
}
