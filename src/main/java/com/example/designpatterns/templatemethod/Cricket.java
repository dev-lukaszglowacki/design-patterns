package com.example.designpatterns.templatemethod;

public class Cricket extends Game {
    @Override
    public String endPlay() {
        return "Cricket Game Finished!";
    }

    @Override
    public String initialize() {
        return "Cricket Game Initialized! Start playing.";
    }

    @Override
    public String startPlay() {
        return "Cricket Game Started. Enjoy the game!";
    }
}
