package com.shri.questions;

class Bicycle {

    void run() {
        System.out.println("super class run");
    }

    static void ride() {
        System.out.println("super class ride");
    }

}

public class Hero extends Bicycle {
    void run() {
        System.out.println("sub class run ");
    }

    static void ride() {
        System.out.println("sub class ride");
    }

    public static void main(String args[]) {
        Bicycle b = new Hero();
        b.run();
        b.ride();
    }
}