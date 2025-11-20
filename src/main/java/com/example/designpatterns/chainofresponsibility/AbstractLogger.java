package com.example.designpatterns.chainofresponsibility;

public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public String logMessage(int level, String message){
        if(this.level <= level){
            return write(message);
        }
        if(nextLogger !=null){
            return nextLogger.logMessage(level, message);
        }
        return "";
    }

    abstract protected String write(String message);
}
