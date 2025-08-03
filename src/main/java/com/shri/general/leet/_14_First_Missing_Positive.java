package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _14_First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {

        int totalElements = nums.length;

        for (int pointer = 0; pointer < totalElements; pointer++) {

            // Ignore negative numbers and numbers greater than totalElements
            while (nums[pointer] > 0 && nums[pointer] <= totalElements && nums[pointer] != nums[nums[pointer] - 1]) {
                // Swap the elements to their correct positions
                int temp = nums[nums[pointer] - 1];
                nums[nums[pointer] - 1] = nums[pointer];
                nums[pointer] = temp;
            }
        }

        // After rearranging, find the first missing positive
        for (int i = 0; i < totalElements; i++) {
            // The first index where the value is not equal to index + 1 is the missing positive
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return totalElements+1;

    }

    @Test
    public void test1() {
        assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
    }

    @Test
    public void test2() {
        assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    public void test2_a() {
        assertEquals(1, firstMissingPositive(new int[]{3, 4, -1, -1}));
    }

    @Test
    public void test3() {
        assertEquals(1, firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(1, firstMissingPositive(new int[]{}));
    }

    @Test
    public void testAllNegatives() {
        assertEquals(1, firstMissingPositive(new int[]{-3, -2, -1}));
    }

    @Test
    public void testWithDuplicates() {
        assertEquals(2, firstMissingPositive(new int[]{1, 1, 0, -1}));
    }

    @Test
    public void testConsecutiveNumbers() {
        assertEquals(6, firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testUnorderedArray() {
        assertEquals(4, firstMissingPositive(new int[]{2, 3, 1, 5}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(2, firstMissingPositive(new int[]{1}));
        assertEquals(1, firstMissingPositive(new int[]{2}));
    }

}