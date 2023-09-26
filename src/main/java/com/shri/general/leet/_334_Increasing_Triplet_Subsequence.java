package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * 334. Increasing Triplet Subsequence
 * <p>
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such
 * that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * <p>
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * <p>
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class _334_Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {

        /* 2,1,5,0,4,7,6
         */
        int arrayLength = nums.length;
        int number1 = Integer.MAX_VALUE;
        int number2 = Integer.MAX_VALUE;
        int number3 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= number1) number1 = num;
            else if (num <= number2) number2 = num;
            else if (num <= number3) {
                number3 = num;
                System.out.println(number1 + ", " + number2 + ", " + number3);
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, new _334_Increasing_Triplet_Subsequence().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(false, new _334_Increasing_Triplet_Subsequence().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(true, new _334_Increasing_Triplet_Subsequence().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(true, new _334_Increasing_Triplet_Subsequence().increasingTriplet(new int[]{2, 1, 5, 4, 6}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(false, new _334_Increasing_Triplet_Subsequence().increasingTriplet(new int[]{1, 1, 1, 1, 1, 1}));
    }

}
