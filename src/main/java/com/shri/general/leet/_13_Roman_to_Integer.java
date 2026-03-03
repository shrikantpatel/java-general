package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class _13_Roman_to_Integer {

    public int romanToInt(String s) {

        int ans = 0;
        int previousCharValue = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            int temp = single_Roman_to_Integer(c);
            if (temp > previousCharValue) {
                temp = temp - 2 * previousCharValue;
            }
            ans = temp + ans;
            previousCharValue = temp;
        }

        return ans;
    }

    private int single_Roman_to_Integer(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid roman char: " + c);
        };
    }

    // ------------------------------------------------------------
    // JUnit 5 tests validating correctness (no solution included)
    // ------------------------------------------------------------
    @Nested
    class Tests {

        @Test
        void testSimpleValues() {
            _13_Roman_to_Integer solver = new _13_Roman_to_Integer();

            Assertions.assertEquals(1, solver.romanToInt("I"));
            Assertions.assertEquals(5, solver.romanToInt("V"));
            Assertions.assertEquals(10, solver.romanToInt("X"));
            Assertions.assertEquals(50, solver.romanToInt("L"));
            Assertions.assertEquals(100, solver.romanToInt("C"));
            Assertions.assertEquals(500, solver.romanToInt("D"));
            Assertions.assertEquals(1000, solver.romanToInt("M"));
        }

        @Test
        void testAdditiveCases() {
            _13_Roman_to_Integer solver = new _13_Roman_to_Integer();

            Assertions.assertEquals(2, solver.romanToInt("II"));
            Assertions.assertEquals(15, solver.romanToInt("XV"));
            Assertions.assertEquals(30, solver.romanToInt("XXX"));
            Assertions.assertEquals(111, solver.romanToInt("CXI"));
        }

        @Test
        void testSubtractiveCases() {
            _13_Roman_to_Integer solver = new _13_Roman_to_Integer();

            Assertions.assertEquals(4, solver.romanToInt("IV"));
            Assertions.assertEquals(9, solver.romanToInt("IX"));
            Assertions.assertEquals(40, solver.romanToInt("XL"));
            Assertions.assertEquals(90, solver.romanToInt("XC"));
            Assertions.assertEquals(400, solver.romanToInt("CD"));
            Assertions.assertEquals(900, solver.romanToInt("CM"));
        }

        @Test
        void testMixedCases() {
            _13_Roman_to_Integer solver = new _13_Roman_to_Integer();

            Assertions.assertEquals(58, solver.romanToInt("LVIII"));   // 50 + 5 + 3
            Assertions.assertEquals(1994, solver.romanToInt("MCMXCIV")); // 1000 + 900 + 90 + 4
            Assertions.assertEquals(621, solver.romanToInt("DCXXI"));
        }

        @Test
        void testEdgeCases() {
            _13_Roman_to_Integer solver = new _13_Roman_to_Integer();

            Assertions.assertEquals(3, solver.romanToInt("III"));
            Assertions.assertEquals(20, solver.romanToInt("XX"));
            Assertions.assertEquals(1666, solver.romanToInt("MDCLXVI"));
        }
    }
}