package com.example.designpatterns.adapter;

public class PrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public String print(String message) {
        return legacyPrinter.printText(message);
    }
}
