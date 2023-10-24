package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0
 */
public class Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int pivot = 0;

        while (left <= right) {
            pivot = right - (right - left) / 2;
            if (target == nums[pivot]) return pivot;
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    @Test
    public void testScenario1() {
        Search_Insert_Position test = new Search_Insert_Position();
        assertEquals(2, test.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    public void testScenario2() {
        Search_Insert_Position test = new Search_Insert_Position();
        assertEquals(1, test.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    @Test
    public void testScenario3() {
        Search_Insert_Position test = new Search_Insert_Position();
        assertEquals(4, test.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    @Test
    public void testScenario4() {
        Search_Insert_Position test = new Search_Insert_Position();
        assertEquals(0, test.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
