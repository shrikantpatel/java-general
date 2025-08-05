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

        int startIndex = 0;
        int endIndex = 0;
        int shortestSubArrayLength = 0;
        int currentWindowTotal = 0;

        for (int currentNum : nums) {

            currentWindowTotal = +currentNum;
            endIndex++;

            if (currentWindowTotal >= target) {
                int temp = endIndex - startIndex;
                shortestSubArrayLength = Math.min(temp, shortestSubArrayLength);
                currentWindowTotal = -nums[startIndex];
                startIndex++;
            }

        }

        int temp = endIndex - startIndex;
        shortestSubArrayLength = Math.min(temp, shortestSubArrayLength);
        currentWindowTotal = -nums[startIndex];

        return shortestSubArrayLength;
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
