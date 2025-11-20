package com.example.designpatterns.abstractfactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public String paint() {
        return button.paint() + " | " + checkbox.paint();
    }
}
