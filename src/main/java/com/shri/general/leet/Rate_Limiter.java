package com.shri.general.leet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * HackerRank-style interview problem: Rate Limiter scheduling
 */
public class Rate_Limiter {

    public static int calculateSchedulingTime(List<Integer> capacity, long requests) {
        int result = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(capacity);

        while (requests > 0) {
            // find the server with max capacity after each iteration
            int index = 0;
            int max = 0;
            for (int i = 0; i < capacity.size(); i++) {
                if (capacity.get(i) > max) {
                    index = i;
                    max = capacity.get(i);
                }
            }

            int cap = capacity.get(index);
            requests -= cap;
            capacity.set(index, cap / 2); // halve the capacity after use
            result++;
        }

        return result;
    }

    // -------------------------------
    // JUnit 5 tests inside the class
    // -------------------------------
    public static class Rate_Limiter_Test {

        @Test
        void testSingleServerExactRequests() {
            assertEquals(1, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(5)), 5));
        }

        //@Test
        void testSingleServerMoreRequests() {
            // One server with capacity 5, 12 requests
            // Iterations: 5 -> 2 -> 1 -> 0 (total 4 steps)
            assertEquals(4, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(5)), 12));
        }

        @Test
        void testMultipleServersBalanced() {
            // Two servers [5, 5], 10 requests
            assertEquals(2, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(5, 5)), 10));
        }

        @Test
        void testMultipleServersUnbalanced() {
            // Servers [10, 1], 11 requests
            assertEquals(2, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(10, 1)), 11));
        }

        @Test
        void testLargeRequests() {
            // Servers [8, 4], 20 requests
            assertEquals(7, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(8, 4)), 20));
        }

        @Test
        void testZeroRequests() {
            assertEquals(0, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(5, 10)), 0));
        }

        @Test
        void testEmptyCapacityList() {
            assertEquals(0, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(), 0));
        }
    }
}