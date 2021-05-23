package com.company.concurrency;

public class PhoneThread implements Runnable {

    @Override
    public void run() {
        try {
            for(int i = 10; i < 20; i++) {
                System.out.println("Phone steps: " + i);
//                1 sec = 1000 milisecunde
//                1 minut = 60 * 1000 (60000)
//                1 ora = 60 * 60 * 1000 (3600000)
//                1 zi = 24 * 60 * 60 * 1000
//                1 saptamana = 7 * 24 * 60 * 60 * 1000
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
