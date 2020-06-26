package com.shri.inherit;

class Uber {

    private static String name = "Uber";

    public static void printName() {
        System.out.println(name);
    }
}

class Minor extends Uber{


    public static void main (String[] args) {
        printName();
    }

}
