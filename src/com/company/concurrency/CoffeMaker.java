package com.company.concurrency;

public class CoffeMaker extends Thread {

    private int time;
    public CoffeMaker(int time) {
        this.time = time;
    }
    /**
     * In metoda run() vom preciza ce sa faca threadul nostru
     * in acest sa prepare cafeaua
     */
    @Override
    public void run() {
        super.run();

        try {
            for(int i = 0 ; i < 10; i++) {
                System.out.println("Coffe Step: " + i);
                Thread.sleep(time);
            }
        } catch (Exception e) {

        }
    }
}
