package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class _739_Daily_Temperatures_1 {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] ans = new int[len];

        // PriorityQueue stores temperatures in ascending order (min-heap).
        // This means queue.peek() gives the *smallest* temperature seen so far.
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Map stores: temperature → index
        // NOTE: This breaks when temperatures repeat (duplicate keys overwrite).
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0 ; i < len ; i++) {

            int current = temperatures[i];
            ans[i] = 0; // default: no warmer day found yet

            // While the smallest temperature in the queue is less than current,
            // it means we found a warmer day for that earlier temperature.
            while (!queue.isEmpty() && queue.peek() < current) {

                // Remove the smallest temperature
                int val = queue.poll();

                // Get the index where that temperature occurred
                List<Integer> indexes = map.get(val);

                // Number of days waited = current index - previous index
                if (indexes != null){
                    for (int index : indexes) {
                        ans[index] = i - index;
                    }
                }

                // Remove it from the map since we resolved it
                map.remove(val);
            }

            // Add current temperature to the queue
            queue.add(current);

            // Store its index
            // NOTE: If the same temperature appears again, this overwrites the old index.
            map.computeIfAbsent(current, k -> new ArrayList<>()).add(i);

        }

        return ans;
    }

    // -------------------------
    // Embedded JUnit 5 Test Cases
    // -------------------------

    @Test
    public void testCustomCase_8970() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] expected = {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testExample1() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testAllIncreasing() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testAllDecreasing() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {90, 80, 70, 60};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testSingleElement() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {100};
        int[] expected = {0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testFlatTemperatures() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {50, 50, 50, 50};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }

    @Test
    public void testMixedPattern() {
        _739_Daily_Temperatures_1 sol = new _739_Daily_Temperatures_1();

        int[] input = {60, 62, 61, 70, 65, 80};
        int[] expected = {1, 2, 1, 2, 1, 0};

        assertArrayEquals(expected, sol.dailyTemperatures(input));
    }
}