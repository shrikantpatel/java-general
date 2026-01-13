package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class _621_Task_Scheduler {

    public int leastInterval(char[] tasks, int coolDownPeriod) {

        // Count frequency of each task (A–Z)
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Max-heap: highest remaining frequency at the top
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        // Push only non-zero frequencies
        for (int count : freq) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int result = 0;

        // Process tasks until heap is empty
        while (!maxHeap.isEmpty()) {

            // We can execute up to (coolDownPeriod + 1) tasks in one cycle
            // This ensures identical tasks are spaced at least n apart
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < coolDownPeriod + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());   // take the most frequent task
                }
            }

            // Decrement each executed task and reinsert if it still has remaining count
            for (Integer count : temp) {
                if (count - 1 > 0) {
                    maxHeap.add(count - 1);
                }
            }

            // If heap is empty, we only add the number of tasks executed
            // (no need to pad with idle time at the end)
            if (maxHeap.isEmpty()) {
                result += temp.size();
            } else {
                // Otherwise, we must account for a full cycle of (n + 1)
                result += coolDownPeriod + 1;
            }
        }

        return result;
    }


    // -------------------------------------------------------
    // JUNIT TESTS (inside the same class as requested)
    // -------------------------------------------------------

    @Test
    void testExample1() {
        _621_Task_Scheduler scheduler = new _621_Task_Scheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        // Expected result from LeetCode example
        assertEquals(8, scheduler.leastInterval(tasks, n));
    }

    @Test
    void testExample2() {
        _621_Task_Scheduler scheduler = new _621_Task_Scheduler();
        char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B'};
        int n = 1;

        assertEquals(6, scheduler.leastInterval(tasks, n));
    }

    @Test
    void testAllSameTasks() {
        _621_Task_Scheduler scheduler = new _621_Task_Scheduler();
        char[] tasks = {'A', 'A', 'A', 'A'};
        int n = 3;

        // Must wait full cooldown between each A
        assertEquals(13, scheduler.leastInterval(tasks, n));
    }

    @Test
    void testNoCooldown() {
        _621_Task_Scheduler scheduler = new _621_Task_Scheduler();
        char[] tasks = {'A', 'B', 'C', 'D'};
        int n = 0;

        // No cooldown means just execute tasks
        assertEquals(4, scheduler.leastInterval(tasks, n));
    }

    @Test
    void testSingleTask() {
        _621_Task_Scheduler scheduler = new _621_Task_Scheduler();
        char[] tasks = {'A'};
        int n = 10;

        assertEquals(1, scheduler.leastInterval(tasks, n));
    }

    @Test
    void testLargeCooldown() {
        _621_Task_Scheduler scheduler = new _621_Task_Scheduler();
        char[] tasks = {'A', 'B'};
        int n = 10;

        // AB
        assertEquals(2, scheduler.leastInterval(tasks, n));
    }
}
