package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class _56_Merge_Intervals {

    public int[][] merge(int[][] intervals) {

        // Result container for merged intervals
        List<int[]> list = new ArrayList<>();

        // Step 1: Sort intervals by their start time.
        // Sorting ensures that any overlapping intervals will appear next to each other.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize the "previous" interval as the first one.
        // This will be expanded or replaced as we scan through the list.
        int[] previous = intervals[0];

        // Step 3: Scan through the remaining intervals and merge when needed.
        for (int i = 1; i < intervals.length; i++) {

            // If the current interval overlaps with the previous one:
            // Overlap condition: current.start <= previous.end
            if (intervals[i][0] <= previous[1]) {

                // After sorting, intervals[i][0] is always >= previous[0],
                // so updating previous[0] with Math.min(...) is unnecessary.
                previous[0] = Math.min(intervals[i][0], previous[0]); // not needed

                // Extend the end of the merged interval to the farthest end.
                previous[1] = Math.max(intervals[i][1], previous[1]);
            }
            else {
                // No overlap: push the completed "previous" interval into the result list.
                list.add(previous);

                // Start a new merge window with the current interval.
                previous = intervals[i];
            }
        }

        // Add the final merged interval after the loop finishes.
        list.add(previous);

        // Convert List<int[]> to int[][] for the final output.
        return list.toArray(new int[list.size()][]);
    }

    // -------------------------------------------------------
    // JUNIT TESTS (inside the same class as requested)
    // -------------------------------------------------------

    @Test
    void testExample1() {
        _56_Merge_Intervals m = new _56_Merge_Intervals();

        int[][] input = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] expected = {
                {1, 6},
                {8, 10},
                {15, 18}
        };

        assertArrayEquals(expected, m.merge(input));
    }

    @Test
    void testExample2() {
        _56_Merge_Intervals m = new _56_Merge_Intervals();

        int[][] input = {
                {1, 4},
                {4, 5}
        };

        int[][] expected = {
                {1, 5}
        };

        assertArrayEquals(expected, m.merge(input));
    }

    @Test
    void testSingleInterval() {
        _56_Merge_Intervals m = new _56_Merge_Intervals();

        int[][] input = {
                {5, 7}
        };

        int[][] expected = {
                {5, 7}
        };

        assertArrayEquals(expected, m.merge(input));
    }

    @Test
    void testNoOverlap() {
        _56_Merge_Intervals m = new _56_Merge_Intervals();

        int[][] input = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] expected = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        assertArrayEquals(expected, m.merge(input));
    }

    @Test
    void testFullOverlap() {
        _56_Merge_Intervals m = new _56_Merge_Intervals();

        int[][] input = {
                {1, 10},
                {2, 3},
                {4, 8}
        };

        int[][] expected = {
                {1, 10}
        };

        assertArrayEquals(expected, m.merge(input));
    }
}