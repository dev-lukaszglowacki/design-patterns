package com.example.designpatterns.singleton;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {

    private static int instanceCount = 0;

    public SingletonService() {
        instanceCount++;
    }

    public String getMessage() {
        return "Hello from SingletonService! Instance count: " + instanceCount;
    }
}
