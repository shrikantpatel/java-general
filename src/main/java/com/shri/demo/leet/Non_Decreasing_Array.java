package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
665. Non-decreasing Array

Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.


Constraints:

1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5

 */
public class Non_Decreasing_Array {

    public boolean checkPossibility(int[] nums) {

        int change = 0;
        int length = nums.length;

        for (int i = 0; i < length -1 ; i++) {
            if (nums[i] > nums[i+1]) {
                change++;
                if (i > 0 && nums[i+1] < nums[i-1]) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i+1];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return change <= 1;
    }

    @Test
    public void testScenario1() {
        Non_Decreasing_Array s = new Non_Decreasing_Array();
        Assert.assertTrue(s.checkPossibility(new int[]{4, 2, 3}));
    }

    @Test
    public void testScenario2() {
        Non_Decreasing_Array s = new Non_Decreasing_Array();
        Assert.assertFalse(s.checkPossibility(new int[]{4, 2, 1}));
    }

    @Test
    public void testScenario3() {
        Non_Decreasing_Array s = new Non_Decreasing_Array();
        Assert.assertFalse(s.checkPossibility(new int[]{3, 4, 2, 3}));
    }

    @Test
    public void testScenario4() {
        Non_Decreasing_Array s = new Non_Decreasing_Array();
        Assert.assertTrue(s.checkPossibility(new int[]{1, 4, 3, 5}));
    }
}
