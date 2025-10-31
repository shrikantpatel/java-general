package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class _53_Maximum_Subarray {

    public int maxSubArray(int[] nums) {

        int largestSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            largestSum = Math.max(currentSum, largestSum);
        }
        return largestSum;

    }

    @Test
    public void testMixedNumbers() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, maxSubArray(nums));
    }

    @Test
    public void testAllNegative() {
        int[] nums = {-8, -3, -6, -2, -5, -4};
        assertEquals(-2, maxSubArray(nums));
    }

    @Test
    public void testAllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(15, maxSubArray(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {7};
        assertEquals(7, maxSubArray(nums));
    }

    @Test
    public void testLargeNegativeFollowedByPositive() {
        int[] nums = {-1000, 1, 2, 3, 4};
        assertEquals(10, maxSubArray(nums));
    }

    @Test
    public void testZerosAndNegatives() {
        int[] nums = {0, -1, 0, -2, 0};
        assertEquals(0, maxSubArray(nums));
    }

}
