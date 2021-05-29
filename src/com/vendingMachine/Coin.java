package com.vendingMachine;

public class Coin {
    private int id;
    private String title;
    private int value;

    public Coin(String title,int id,int value){
        this.title=title;
        this.id=id;
        this.value=value;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getValue() {
        return value;
    }
}
