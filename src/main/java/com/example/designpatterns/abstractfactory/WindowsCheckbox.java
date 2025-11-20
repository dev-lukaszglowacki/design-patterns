package com.example.designpatterns.abstractfactory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public String paint() {
        return "Painting a Windows checkbox";
    }
}
