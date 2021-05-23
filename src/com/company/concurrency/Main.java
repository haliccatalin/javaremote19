package com.company.concurrency;

public class Main {
    public static void main(String[] args) {
        Bench bench = new Bench(1);

        SeatTakerThread seatTakerThread1 = new SeatTakerThread(bench);
        SeatTakerThread seatTakerThread2 = new SeatTakerThread(bench);

        seatTakerThread1.start();
        seatTakerThread2.start();
    }

    public static void threadSample() {
        // clasa thread ca parinte pentru CoffeMaker
        CoffeMaker coffeMaker = new CoffeMaker(1000);
        coffeMaker.start();

        CoffeMaker coffeMaker2 = new CoffeMaker(500);
        coffeMaker2.start();

        System.out.println("Coffe done!");

//        Interfata Runnable
        PhoneThread phoneThread = new PhoneThread();
//      obiectul phoneThread il trimitem clasei Thread ca si parametru
        Thread thread = new Thread(phoneThread);
//      pornim threadul
        thread.start();
    }
}
