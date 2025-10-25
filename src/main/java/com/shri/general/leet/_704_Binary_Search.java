package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class _704_Binary_Search {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low <= high) {

            mid = (high - low) / 2 + low;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                low = mid + 1;
            if (target < nums[mid])
                high = mid - 1;
        }

        return -1;
    }
    
    @Test
    void testFoundAtBeginning() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {1, 2, 3, 4};
        assertEquals(0, bs.search(nums, 1));
    }

    @Test
    void testFoundAtMiddle() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(2, bs.search(nums, 3));
    }

    @Test
    void testFoundAtEnd() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {2, 4, 6, 8};
        assertEquals(3, bs.search(nums, 8));
    }

    @Test
    void testNotFound() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {1, 3, 5, 7};
        assertEquals(-1, bs.search(nums, 4));
    }

    @Test
    void testEmptyArray() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {};
        assertEquals(-1, bs.search(nums, 10));
    }

    @Test
    void testSingleElementFound() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {42};
        assertEquals(0, bs.search(nums, 42));
    }

    @Test
    void testSingleElementNotFound() {
        _704_Binary_Search bs = new _704_Binary_Search();
        int[] nums = {42};
        assertEquals(-1, bs.search(nums, 7));
    }
}
