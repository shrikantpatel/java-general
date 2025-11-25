/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _33_Search_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) return 0;

        int left = 0;
        int right = nums.length-1;

        while (left < right) {

            int mid = left + (right - left)/2;

            if (target == nums[mid]) return mid;
            if (target == nums[left]) return left;
            if (target == nums[right]) return right;

            // Check if left half is sorted
            if (nums[left] < nums[mid]) {

                // Target lies in left half
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {

                // Target lies in the right half
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    @Test
    void testTargetPresentInRotatedArray() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {4,5,6,7,0,1,2};
        assertEquals(4, solver.search(nums, 0)); // target 0 at index 4
        assertEquals(1, solver.search(nums, 5)); // target 5 at index 1
    }

    @Test
    void testTargetNotPresent() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {4,5,6,7,0,1,2};
        assertEquals(-1, solver.search(nums, 3)); // target 3 not in array
    }

    @Test
    void testSingleElementArray() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {1};
        assertEquals(0, solver.search(nums, 1));
        assertEquals(-1, solver.search(nums, 0));
    }

    @Test
    void testEmptyArray() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {};
        assertEquals(-1, solver.search(nums, 5));
    }

    @Test
    void testNoRotationArray() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {1,2,3,4,5,6,7};
        assertEquals(3, solver.search(nums, 4)); // target 4 at index 3
    }

    @Test
    void testTargetOneInRotatedArray() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {4,5,6,7,0,1,2};
        assertEquals(5, solver.search(nums, 1)); // target 1 at index 5
    }

    @Test
    void testTargetOneInDifferentRotation() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {5,1,2,3,4};
        assertEquals(1, solver.search(nums, 1)); // target 1 at index 1
    }

    @Test
    void testTargetEightInRotatedArray() {
        _33_Search_Rotated_Sorted_Array solver = new _33_Search_Rotated_Sorted_Array();
        int[] nums = {4,5,6,7,8,1,2,3};
        assertEquals(4, solver.search(nums, 8)); // target 8 at index 4
    }


}
