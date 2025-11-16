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

    /**
     * Sorts the input array so that all 0s come first, then 1s, then 2s.
     * Uses the Dutch National Flag algorithm for in-place sorting in one pass.
     *
     * @param nums the array of integers containing only 0, 1, and 2
     */
    public void sortColors1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int low = 0, mid = 0, high = nums.length - 1;

        // Traverse the array and sort the colors in-place
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap current element with the element at low pointer
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Move to the next element if it's 1
                mid++;
            } else {
                // Swap current element with the element at high pointer
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

    public void sortColors2(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int i = 0;
        while (count0-- > 0) nums[i++] = 0;
        while (count1-- > 0) nums[i++] = 1;
        while (count2-- > 0) nums[i++] = 2;
    }

    @Test
    void sortsArrayTest1() {
        int[] nums = {2, 1, 1, 0 , 0, 2};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithAllColorsMixed() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithNoTwos() {
        int[] nums = {1, 0, 1, 0, 1};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 1}, nums);
    }

    @Test
    void sortsArrayWithNoZeros() {
        int[] nums = {2, 1, 2, 1, 2};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithNoOnes() {
        int[] nums = {2, 0, 2, 0, 2};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 2, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithAllSameColor() {
        int[] nums = {1, 1, 1, 1};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1}, nums);
    }

    @Test
    void sortsArrayWithSingleElement() {
        int[] nums = {0};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    void sortsArrayWithTwoElements() {
        int[] nums = {2, 0};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 2}, nums);
    }

    @Test
    void sortsAlreadySortedArray() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsArrayWithAlternatingColors() {
        int[] nums = {0, 2, 1, 0, 2, 1};
        new _75_Sort_Colors().sortColors1(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }
    @Test
    void sortColors2_sortsArrayTest1() {
        int[] nums = {2, 1, 1, 0 , 0, 2};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithAllColorsMixed() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithNoTwos() {
        int[] nums = {1, 0, 1, 0, 1};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 1}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithNoZeros() {
        int[] nums = {2, 1, 2, 1, 2};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 2, 2}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithNoOnes() {
        int[] nums = {2, 0, 2, 0, 2};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 2, 2, 2}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithAllSameColor() {
        int[] nums = {1, 1, 1, 1};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithSingleElement() {
        int[] nums = {0};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithTwoElements() {
        int[] nums = {2, 0};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 2}, nums);
    }

    @Test
    void sortColors2_sortsAlreadySortedArray() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortColors2_sortsArrayWithAlternatingColors() {
        int[] nums = {0, 2, 1, 0, 2, 1};
        new _75_Sort_Colors().sortColors2(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }


}
