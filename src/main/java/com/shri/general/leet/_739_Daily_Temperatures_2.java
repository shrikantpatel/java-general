package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class _739_Daily_Temperatures_2 {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] ans = new int[len];

        //Start from the last day and move backward.
        // The idea: for each day j, look ahead (toward the right) for the next warmer day.
        int i = len - 1;
        while (i >= 0) {

            int cur = temperatures[i];

            // Look backward from i-1 to find days that are colder than the current day.
            // For each such day j, the current day i is the next warmer day.
            int j = i - 1;
            while (j >= 0 && temperatures[j] < cur) {

                // Since temperatures[j] < cur, day i is the next warmer day for j (aleast at this point)
                ans[j] = i - j;

                // Continue moving backward to see if earlier days are also colder.
                j--;
            }

            // Move to the previous day and repeat.
            i--;
        }


        return ans;
    }

    // -------------------------
    // Embedded JUnit 5 Test Cases
    // -------------------------

    @Test
    public void testCustomCase_8970() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] expected = {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testExample1() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testAllIncreasing() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testAllDecreasing() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {90, 80, 70, 60};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testSingleElement() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {100};
        int[] expected = {0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testFlatTemperatures() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {50, 50, 50, 50};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testMixedPattern() {
        _739_Daily_Temperatures_2 sol = new _739_Daily_Temperatures_2();

        int[] input = {60, 62, 61, 70, 65, 80};
        int[] expected = {1, 2, 1, 2, 1, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }
}