package com.shri.general.leet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * HackerRank-style interview problem: Rate Limiter scheduling
 */
public class Rate_Limiter {

    public static int calculateSchedulingTime(List<Integer> capacity, long requests) {
        int result = 0;

        // Max-heap priority queue (largest capacity first)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(capacity);

        while (requests > 0 && !queue.isEmpty()) {
            int cap = queue.remove(); // get largest capacity
            requests -= cap;
            result++;

            int newCap = cap / 2;
            if (newCap > 0) {
                queue.add(newCap); // put halved capacity back
            }
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

        @Test
        void testSingleServerMoreRequests() {
            // One server with capacity 5, 12 requests
            // Iterations: 5 -> 2 -> 1 -> 0 (total 4 steps)
            assertEquals(3, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(5)), 12));
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
            assertEquals(5, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(8, 4)), 20));
        }

        @Test
        void testZeroRequests() {
            assertEquals(0, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(5, 10)), 0));
        }

        @Test
        void testEmptyCapacityList() {
            assertEquals(0, Rate_Limiter.calculateSchedulingTime(new ArrayList<>(), 0));
        }

        @Test
        void testExceedTimeout() {
            // Very large requests to simulate long-running computation
            // This test enforces that the method must finish within 1 second
            assertTimeout(Duration.ofSeconds(1), () -> {
                Rate_Limiter.calculateSchedulingTime(new ArrayList<>(List.of(1000, 500, 250)), 1_000_000);
            });
        }

    }
}