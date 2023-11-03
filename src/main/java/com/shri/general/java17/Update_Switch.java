package com.shri.general.java17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Update_Switch {

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }


    @Test
    public void example1() {
        Day day = Day.MONDAY;
        System.out.println("number character in spelling of the day - " + day + " - " + switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        });
    }

    @Test
    public void example2() {
        int letterInDays = 0;
        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> letterInDays = 6;
            case TUESDAY -> letterInDays = 7;
            case THURSDAY, SATURDAY -> letterInDays = 8;
            case WEDNESDAY -> letterInDays = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        }
        ;
        assertEquals(6, letterInDays);
    }

    @Test
    public void example3() {
        Day day = Day.MONDAY;
        int letterInDays = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        assertEquals(6, letterInDays);
    }

    @Test
    public void example4() {

        Day day = Day.MONDAY;
        int letterInDays = 0;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println(6);
                letterInDays = 6;
            }
            case TUESDAY -> {
                System.out.println(7);
                letterInDays = 7;
            }
            case THURSDAY, SATURDAY -> {
                System.out.println(8);
                letterInDays = 8;
            }
            case WEDNESDAY -> {
                System.out.println(9);
                letterInDays = 9;
            }
            default -> {
                throw new IllegalStateException("Invalid day: " + day);
            }
        }
        ;
        assertEquals(6, letterInDays);
    }

    @Test
    public void example5() {

        Day day = Day.MONDAY;
        int letterInDays = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println(6);
                yield 6;
            }
            case TUESDAY -> {
                System.out.println(7);
                yield 7;
            }
            case THURSDAY, SATURDAY -> {
                System.out.println(8);
                yield 8;
            }
            case WEDNESDAY -> {
                System.out.println(9);
                yield 9;
            }
            default -> {
                throw new IllegalStateException("Invalid day: " + day);
            }
        };
        assertEquals(6, letterInDays);
    }
}
