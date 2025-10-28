package com.shri.general.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
https://leetcode.com/problems/majority-element/description/
 */
public class _169_Majority_Element {

    //Boyer-Moore Voting Algorithm
    public int majorityElement_1(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;

            if (num == candidate) count ++;
            else count--;
        }
        return candidate;
    }

    public int majorityElement_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement_3(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
            if (freq.get(num) > nums.length/2) {
                return num;
            }
        }

        return -1; // Shouldn't happen if majority element is guaranteed
    }



    @Test
    public void testMajorityAtStart() {
        int[] nums1 = {3, 3, 3, 1, 2};
        assertEquals(3, majorityElement_1(nums1));
        int[] nums2 = {3, 3, 3, 1, 2};
        assertEquals(3, majorityElement_2(nums2));
        int[] nums3 = {3, 3, 3, 1, 2};
        assertEquals(3, majorityElement_3(nums3));
    }

    @Test
    public void testMajorityAtEnd() {
        int[] nums1 = {1, 2, 3, 3, 3, 3};
        assertEquals(3, majorityElement_1(nums1));
        int[] nums2 = {1, 2, 3, 3, 3, 3};
        assertEquals(3, majorityElement_2(nums2));
        int[] nums3 = {1, 2, 3, 3, 3, 3};
        assertEquals(3, majorityElement_2(nums3));
    }

    @Test
    public void testSingleElement() {
        int[] nums1 = {99};
        assertEquals(99, majorityElement_1(nums1));
        int[] nums2 =  {99};
        assertEquals(99, majorityElement_2(nums2));
        int[] nums3 =  {99};
        assertEquals(99, majorityElement_3(nums3));
    }

    @Test
    public void testAllSameElements() {
        int[] nums1 = {7, 7, 7, 7, 7};
        assertEquals(7, majorityElement_1(nums1));
        int[] nums2 = {7, 7, 7, 7, 7};
        assertEquals(7, majorityElement_2(nums2));
        int[] nums3 = {7, 7, 7, 7, 7};
        assertEquals(7, majorityElement_3(nums2));
    }

    @Test
    public void testMajorityExactlyHalfPlusOne() {
        int[] nums1 = {1, 2, 1, 2, 2, 1, 1, 2, 2};
        assertEquals(2, majorityElement_1(nums1));
        int[] nums2 = {1, 2, 1, 2, 2, 1, 1, 2, 2};
        assertEquals(2, majorityElement_2(nums2));
        int[] nums3 = {1, 2, 1, 2, 2, 1, 1, 2, 2};
        assertEquals(2, majorityElement_3(nums3));
    }

}
