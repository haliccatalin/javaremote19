package com.coding;

public class SingletonPattern {
    private int count = 0;
    private String name = "jhon";

    private static SingletonPattern singletonPatternInstance;

    private SingletonPattern() {

    }

    public static SingletonPattern getInstance() {
        if(singletonPatternInstance == null) {
            singletonPatternInstance = new SingletonPattern();
        }

        return singletonPatternInstance;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
