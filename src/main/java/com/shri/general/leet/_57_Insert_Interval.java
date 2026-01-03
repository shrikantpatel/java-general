package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class _57_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int counter = 0;
        int length = intervals.length;

        // 1. Add all intervals that end before newInterval starts
        while (counter < length && intervals[counter][1] < newInterval[0]) {
            result.add(intervals[counter]);
            counter++;
        }

        // 2. Merge all overlapping intervals
        while (counter < length && intervals[counter][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[counter][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[counter][1]);
            counter++;
        }

        // Add merged interval
        result.add(newInterval);

        // 3. Add remaining intervals
        while (counter < length) {
            result.add(intervals[counter]);
            counter++;
        }

        return result.toArray(new int[result.size()][]);

    }

    @Test
    void testInsertIntoEmpty() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {};
        int[] newInterval = {2, 5};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{2, 5}, result[0]);
    }

    @Test
    void testInsertNoOverlapBefore() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{5, 7}};
        int[] newInterval = {1, 3};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(2, result.length);
        assertArrayEquals(new int[]{1, 3}, result[0]);
        assertArrayEquals(new int[]{5, 7}, result[1]);
    }

    @Test
    void testInsertNoOverlapAfter() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 2}};
        int[] newInterval = {5, 7};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(2, result.length);
        assertArrayEquals(new int[]{1, 2}, result[0]);
        assertArrayEquals(new int[]{5, 7}, result[1]);
    }

    @Test
    void testInsertWithSingleMerge() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(2, result.length);
        assertArrayEquals(new int[]{1, 5}, result[0]);
        assertArrayEquals(new int[]{6, 9}, result[1]);
    }

    @Test
    void testInsertWithMultipleMerges() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 2}, result[0]);
        assertArrayEquals(new int[]{3, 10}, result[1]);
        assertArrayEquals(new int[]{12, 16}, result[2]);
    }

    @Test
    void testInsertExactTouchingLeft() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 2}, {5, 7}};
        int[] newInterval = {2, 5};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{1, 7}, result[0]);
    }

    @Test
    void testInsertExactTouchingRight() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {3, 6};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{1, 9}, result[0]);
    }

    @Test
    void testInsertInsideExistingInterval() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 10}};
        int[] newInterval = {3, 5};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{1, 10}, result[0]);
    }

    @Test
    void testInsertAtBeginning() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{5, 7}, {8, 10}};
        int[] newInterval = {1, 3};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 3}, result[0]);
    }

    @Test
    void testInsertAtEnd() {
        _57_Insert_Interval solver = new _57_Insert_Interval();

        int[][] intervals = {{1, 2}, {3, 4}};
        int[] newInterval = {10, 12};

        int[][] result = solver.insert(intervals, newInterval);

        assertEquals(3, result.length);
        assertArrayEquals(new int[]{10, 12}, result[2]);
    }

}
