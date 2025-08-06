package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is
 * greater than or equal to target. If there is no such subarray, return 0 instead.

 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class _209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {

        // Handle edge cases: null array, empty array, or non-positive target
        if (nums == null || nums.length == 0 || target <= 0) return 0;

        // Initialize pointers and variables for sliding window
        int startIndex = 0, endIndex = 0, currentWindowTotal = 0;
        int shortestSubArrayLength = Integer.MAX_VALUE;

        // Expand the window by moving endIndex
        while (endIndex < nums.length) {
            currentWindowTotal += nums[endIndex]; // Add current element to window sum

            // Shrink the window from the left while the sum meets or exceeds target
            while (currentWindowTotal >= target) {
                // Update shortest length if current window is smaller
                shortestSubArrayLength = Math.min(endIndex - startIndex + 1, shortestSubArrayLength);
                currentWindowTotal -= nums[startIndex]; // Remove leftmost element from sum
                startIndex++; // Move left pointer forward
            }

            endIndex++; // Move right pointer forward
        }

        // Return result: 0 if no valid subarray found, else shortest length
        return shortestSubArrayLength == Integer.MAX_VALUE ? 0 : shortestSubArrayLength;
    }

    @Test
    void testExample1() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(2, obj.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    @Test
    void testExample2() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(1, obj.minSubArrayLen(4, new int[]{1,4,4}));
    }

    @Test
    void testExample3() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(0, obj.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    @Test
    void testSingleElementEqualToTarget() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(1, obj.minSubArrayLen(5, new int[]{5}));
    }

    @Test
    void testSingleElementLessThanTarget() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(0, obj.minSubArrayLen(10, new int[]{5}));
    }

    @Test
    void testEmptyArray() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(0, obj.minSubArrayLen(1, new int[]{}));
    }

    @Test
    void testAllElementsLessThanTarget() {
        _209_Minimum_Size_Subarray_Sum obj = new _209_Minimum_Size_Subarray_Sum();
        assertEquals(0, obj.minSubArrayLen(100, new int[]{1,2,3,4,5}));
    }
}
