package com.company.nested.classes;

public class Car {
    private int maxSpeed = 200;

    public Car() {

    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public static class Mechanic {

        public void repair(Car car) {
// nested static class can refer
// private field of outer class
            car.maxSpeed += 15;
        }
    }

}
