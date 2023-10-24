package com.shri.general.java17;

public class Update_Switch {

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }

    public static void main(String[] args) {

        //print the number of character in each day
        example1();
        example2();
        example3();
        example4();
    }

    private static void example1() {
        Day day = Day.WEDNESDAY;
        System.out.println("number character in spelling of the day - " + day + " - " + switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        });
    }

    private static void example2() {
        int numLetters = 0;
        Day day = Day.WEDNESDAY;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY -> numLetters = 7;
            case THURSDAY, SATURDAY -> numLetters = 8;
            case WEDNESDAY -> numLetters = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        }
        ;
        System.out.println("number character in spelling of the day - " + day + " - " + numLetters);
    }

    private static void example3() {
        Day day = Day.WEDNESDAY;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println("number character in spelling of the day - " + day + " - " + numLetters);
    }

    private static void example4() {

        Day day = Day.WEDNESDAY;
        int numLetters = switch (day) {
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
        System.out.println("number character in spelling of the day - " + day + " - " + numLetters);
    }
}
