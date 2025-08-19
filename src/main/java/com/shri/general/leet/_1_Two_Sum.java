package com.shri.general.leet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/two-sum/description/
 * <p>
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class _1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {

        // Map to store number -> index for quick lookup
        Map<Integer, Integer> lookup = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // The number needed to reach the target

            // Check if the complement has already been seen
            if (lookup.containsKey(complement)) {
                // Return the indices of the complement and current number
                return new int[] { lookup.get(complement), i };
            }

            // Store the current number and its index
            lookup.put(nums[i], i);
        }
        return null;
    }

    private _1_Two_Sum solution;

    @BeforeEach
    void setUp() {
        solution = new _1_Two_Sum();
    }

    @Test
    public void testBasicCase() {
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testMultiplePairs() {
        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void testNegativeNumbers() {
        int[] result = solution.twoSum(new int[]{-3, 4, 3, 90}, 0);
        assertArrayEquals(new int[]{0, 2}, result);
    }

    @Test
    public void testDuplicates() {
        int[] result = solution.twoSum(new int[]{1, 5, 1, 5}, 10);
        assertArrayEquals(new int[]{1, 3}, result);
    }

    @Test
    public void testLargeInput() {
        int[] nums = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int[] result = solution.twoSum(nums, 19999);
        assertArrayEquals(new int[]{9998, 9999}, result);
    }
}

