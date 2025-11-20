package com.example.designpatterns.abstractfactory;

public class MacOSCheckbox implements Checkbox {
    @Override
    public String paint() {
        return "Painting a MacOS checkbox";
    }
}
