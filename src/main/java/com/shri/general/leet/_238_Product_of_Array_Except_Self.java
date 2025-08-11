package com.shri.general.leet;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 238. Product of Array Except Self
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * <p>
 * Medium
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class _238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] answer = new int[size];

        // answer[i] will hold the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < size; i++) {
            // Multiply previous product by previous element
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // suffix holds the product of all elements to the right of i
        int suffix = 1;
        for (int i = size - 1; i >= 0; i--) {
            // Multiply left product (answer[i]) by right product (suffix)
            answer[i] = answer[i] * suffix;
            // Update suffix to include current element
            suffix = nums[i] * suffix;
        }

        return answer;
    }

    @Test
    void returnsProductExceptSelfForPositiveNumbers() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        Assertions.assertArrayEquals(expected, new _238_Product_of_Array_Except_Self().productExceptSelf(nums));
    }

    @Test
    void returnsProductExceptSelfWithZeroPresent() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        Assertions.assertArrayEquals(expected, new _238_Product_of_Array_Except_Self().productExceptSelf(nums));
    }

    @Test
    void returnsProductExceptSelfWithAllOnes() {
        int[] nums = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, new _238_Product_of_Array_Except_Self().productExceptSelf(nums));
    }

    @Test
    void returnsProductExceptSelfWithTwoElements() {
        int[] nums = {5, 10};
        int[] expected = {10, 5};
        Assertions.assertArrayEquals(expected, new _238_Product_of_Array_Except_Self().productExceptSelf(nums));
    }

    @Test
    void returnsProductExceptSelfWithNegativeNumbers() {
        int[] nums = {-2, -3, -4};
        int[] expected = {12, 8, 6};
        Assertions.assertArrayEquals(expected, new _238_Product_of_Array_Except_Self().productExceptSelf(nums));
    }

}
