package com.example.demo.util;

public class RelationBetweenClasses {

    Vehicle vehicle = new Car();
    Vehicle vehicle2 = new Audi();
    Car car = new Audi();
}

interface Vehicle {
    int madeInYear();
}

class Car implements Vehicle {

    @Override
    public int madeInYear() {
        return 0;
    }
}

class Audi extends Car {
}
