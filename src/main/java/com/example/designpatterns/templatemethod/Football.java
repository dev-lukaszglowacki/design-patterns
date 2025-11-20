package com.example.designpatterns.templatemethod;

public class Football extends Game {
    @Override
    public String endPlay() {
        return "Football Game Finished!";
    }

    @Override
    public String initialize() {
        return "Football Game Initialized! Start playing.";
    }

    @Override
    public String startPlay() {
        return "Football Game Started. Enjoy the game!";
    }
}
