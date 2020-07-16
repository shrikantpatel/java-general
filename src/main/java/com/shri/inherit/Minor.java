package com.shri.inherit;

class Uber {

    static String name = "Uber";

    public static void printName() {
        System.out.println(name);
    }
}

class Minor extends Uber{

    static String name = "Minor";

    public static void main (String[] args) {
        printName();
    }

    public static void printName() {
        Uber.printName();
        System.out.println(name);
    }

}
