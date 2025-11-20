package com.example.designpatterns.mediator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatRoom {
    public static String showMessage(User user, String message){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + now.format(formatter) + "] [" + user.getName() + "] : " + message;
    }
}
