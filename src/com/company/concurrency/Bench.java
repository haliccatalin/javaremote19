package com.company.concurrency;

public class Bench {
    private int availableSeats;

    public Bench(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void takeASeat() {
        if (availableSeats > 0) {
            System.out.println("Taking a seat.");
            availableSeats--;
            System.out.println("Free seats left " + availableSeats);
        } else {
            System.out.println("There are no available seats. :(");
        }
    }
}
