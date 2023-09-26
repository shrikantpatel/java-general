package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * 15. 3Sum
 * Medium
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class _15_Find_3_Sums {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> allTriplets = new ArrayList<>();
        Arrays.sort(nums);

        // start from first element and go to 3rd last element
        for (int i = 0; i < nums.length - 2; i++) {

            // this to eliminate duplicate triplets
            if (i > 0 &&nums[i] == nums[i - 1]) continue;

            // pointer to next element in the array
            int j = i + 1;
            // pointer to last element in the array
            int k = nums.length - 1;

            int target = -nums[i];

            // start iteration where left pointer is  next element and right pointer is at last element
            // continue coming to enter from either side
            while (j < k) {

                if (nums[j] + nums[k] == target) {
                    allTriplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // keep incrementing j till find non duplicate element.. this to eliminate duplicate triplets
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    // keep decrementing k till find non duplicate element.. this to eliminate duplicate triplets
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                // if sum of j and k element > target we move k to j
                else if (nums[j] + nums[k] > target) {
                    k--;
                }
                // if sum of j and k element < target we move j to k
                else if (nums[j] + nums[k] < target) {
                    j++;
                }
            }

        }

        return allTriplets;
    }

    @Test
    public void test1() {
        Assert.assertEquals(Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)), threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(new ArrayList<>(), threeSum(new int[]{0, 1, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(Arrays.asList(Arrays.asList(0, 0, 0)), threeSum(new int[]{0, 0, 0}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(Arrays.asList(Arrays.asList(-2,0,2), Arrays.asList(-2,1,1)), threeSum(new int[]{-2,0,1,1,2}));
    }

}
