package com.shri.general.java17;

import java.util.List;

public class Using_Var {

    public static void main(String[] args) {
        var Roland = new Person_internal("Roland", "Deschain");
        var Susan = new Person_internal("Susan", "Delgado");
        var Eddie = new Person_internal("Eddie", "Dean");
        var Detta = new Person_internal("Detta", "Walker");
        var Jake = new Person_internal("Jake", "Chambers");

        var persons = List.of(Roland, Susan, Eddie, Detta, Jake);

        for (var person : persons) {
            System.out.println(person.name + " - " + person.lastname);
        }
    }

}

class Person_internal {


    public final String name;
    public final String lastname;

    public Person_internal(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

}