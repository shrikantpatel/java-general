/**
 * https://leetcode.com/problems/sort-colors/description/
 * <p>
 * 75. Sort Colors
 * Solved
 * Medium
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _75_Sort_Colors {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    void sortsArray() {
        int[] nums = {2, 1, 1, 0 , 0, 2};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithAllColorsMixed() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithNoTwos() {
        int[] nums = {1, 0, 1, 0, 1};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 1}, nums);
    }

    @Test
    void sortsArrayWithNoZeros() {
        int[] nums = {2, 1, 2, 1, 2};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithNoOnes() {
        int[] nums = {2, 0, 2, 0, 2};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 2, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithAllSameColor() {
        int[] nums = {1, 1, 1, 1};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1}, nums);
    }

    @Test
    void sortsArrayWithSingleElement() {
        int[] nums = {0};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    void sortsArrayWithTwoElements() {
        int[] nums = {2, 0};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 2}, nums);
    }

    @Test
    void sortsAlreadySortedArray() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithAlternatingColors() {
        int[] nums = {0, 2, 1, 0, 2, 1};
        new _75_Sort_Colors().sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

}
