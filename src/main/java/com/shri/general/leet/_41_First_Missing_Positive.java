package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p>
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * <p>
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are present but 3 is missing.
 * <p>
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: The numbers in the range [1,3] are present but 2 is missing.
 * <p>
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The numbers in the range [1,7] are not present so 1 is the smallest missing positive integer.
 */
class _41_First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {

        int totalElements = nums.length;

        for (int counter = 0; counter < totalElements; counter++) {
            while (nums[counter] > 0 && nums[counter] < totalElements + 1 && nums[counter] != nums[nums[counter] - 1]) {

                // Swap the elements to their correct positions
                int temp = nums[counter];
                nums[counter] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // After rearranging, the first index where the value is not equal to index + 1 is the missing positive
        for (int counter = 0; counter < totalElements; counter++) {
            if (nums[counter] != counter + 1) {
                return counter + 1;
            }
        }
        return totalElements + 1; // If all positions are filled correctly, return the next positive integer
    }


    public int firstMissingPositive_hashset(int[] nums) {

        Set<Integer> posNumPresent = new HashSet<>();

        // store all the 0 and length of array in numPresent
        for (int num : nums) {
            if (num > 0 && num <= nums.length) posNumPresent.add(num);
        }

        // check if the number
        for (int i = 1; i <= nums.length; i++) {
            if (!posNumPresent.contains(i)) return i;
        }

        return -1;

    }

    @Test
    public void test1() {
        assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(3, firstMissingPositive_hashset(new int[]{1, 2, 0}));
    }

    @Test
    public void test2() {
        assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(2, firstMissingPositive_hashset(new int[]{3, 4, -1, 1}));
    }

    @Test
    public void test2_a() {
        assertEquals(1, firstMissingPositive(new int[]{3, 4, -1, -1}));
        assertEquals(1, firstMissingPositive_hashset(new int[]{3, 4, -1, -1}));
    }

    @Test
    public void test3() {
        assertEquals(1, firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        assertEquals(1, firstMissingPositive_hashset(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(1, firstMissingPositive(new int[]{}));
        assertEquals(1, firstMissingPositive_hashset(new int[]{}));
    }

    @Test
    public void testAllNegatives() {
        assertEquals(1, firstMissingPositive(new int[]{-3, -2, -1}));
        assertEquals(1, firstMissingPositive_hashset(new int[]{-3, -2, -1}));
    }

    @Test
    public void testWithDuplicates() {
        assertEquals(2, firstMissingPositive(new int[]{1, 1, 0, -1}));
        assertEquals(2, firstMissingPositive_hashset(new int[]{1, 1, 0, -1}));
    }

    @Test
    public void testConsecutiveNumbers() {
        assertEquals(6, firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
        assertEquals(6, firstMissingPositive_hashset(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testUnorderedArray() {
        assertEquals(4, firstMissingPositive(new int[]{2, 3, 1, 5}));
        assertEquals(4, firstMissingPositive_hashset(new int[]{2, 3, 1, 5}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(2, firstMissingPositive(new int[]{1}));
        assertEquals(1, firstMissingPositive(new int[]{2}));
        assertEquals(2, firstMissingPositive_hashset(new int[]{1}));
        assertEquals(1, firstMissingPositive_hashset(new int[]{2}));
    }

}