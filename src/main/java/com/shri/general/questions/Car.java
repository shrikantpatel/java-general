package com.shri.general.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Car {

    private String color;
    private static int numberOfWheel = 4;

    public Car() {
        this("White");
        System.out.println("default constructor");
    }

    public Car(String color) {
        this.color = color.toLowerCase();
        System.out.println("created car with color - " + color);
    }

    public String getColor() {
        return color;
    }

    public void printColor() {
        System.out.println("car color is - " + color);
    }

    public static int classprinter() {
        return numberOfWheel;
    }

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        System.out.println("Printing args:");
        Stream.of(args).forEach(c ->cars.add(new Car(c)));

        cars.forEach(Car::printColor);
    }

}

