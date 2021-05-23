package com.company.nested.classes;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // nested classes non-static
        Bicycle bike = new Bicycle();

        // TREBUIE sa avem o instanta a clasei Bicycle
        // pentru a creea o instanta din clasa Wheel
        // pentru ca Wheel depinde de maxSpeed din clasa
        // Bicycle
        Bicycle.Wheel wheel = bike.new Wheel();

        wheel.damage();

        // static classes
        Car.Mechanic mechanic = new Car.Mechanic();

        Car car = new Car();
        mechanic.repair(car);
    }
}
