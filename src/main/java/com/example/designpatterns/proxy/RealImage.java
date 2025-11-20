package com.example.designpatterns.proxy;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public String display() {
        return "Displaying " + fileName;
    }

    private String loadFromDisk(String fileName){
        return "Loading " + fileName;
    }
}
