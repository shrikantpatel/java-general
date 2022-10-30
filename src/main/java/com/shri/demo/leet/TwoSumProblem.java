package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
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
 * <p>
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSumProblem {


    // this is brute force method where we looping through the array twice.
    // the time complexity is n2
    // space complexity is n
    public int[] twoSum3(int[] nums, int target) {
        int totalElement = nums.length;

        for (int outerLoop = 0; outerLoop < totalElement; outerLoop++) {

            int currentElement = nums[outerLoop];

            for (int innerLoop = outerLoop + 1; innerLoop < totalElement; innerLoop++) {

                if (currentElement + nums[innerLoop] == target) {
                    return new int[]{outerLoop, innerLoop};
                }
            }
        }
        return null;
    }

    // We loop the through the array only once.
    // the time complexity is n
    // space complexity is n
    public int[] twoSum(int[] nums, int target) {
        int totalElement = nums.length;
        Map<Integer, Integer> complementFromTarget = new HashMap<>();
        int complement = 0;
        int currentElement = 0;

        for (int index = 0; index < totalElement; index++) {

            // if the current element is the map, then we found the 2 number that total to target, then return that index and current index
            currentElement = nums[index];
            if (complementFromTarget.containsKey(currentElement)) {
                return new int[]{complementFromTarget.get(currentElement), index};
            }
            // calculate the complement of current number and put that in complement & corresponding index in complement map
            complement = target - currentElement;
            complementFromTarget.put(complement, index);

        }
        return null;
    }

    @Test
    public void test1() {
        TwoSumProblem sol = new TwoSumProblem();
        Assert.assertArrayEquals(new int[]{0, 1}, sol.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    public void test2() {
        TwoSumProblem sol = new TwoSumProblem();
        Assert.assertArrayEquals(new int[]{1, 2}, sol.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    public void test3() {
        TwoSumProblem sol = new TwoSumProblem();
        Assert.assertArrayEquals(new int[]{0, 1}, sol.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void test4() {
        TwoSumProblem sol = new TwoSumProblem();
        Assert.assertArrayEquals(new int[]{0, 3}, sol.twoSum(new int[]{2, 5, 11, 7}, 9));
    }

    @Test
    public void test5() {
        TwoSumProblem sol = new TwoSumProblem();
        Assert.assertArrayEquals(new int[]{0, 3}, sol.twoSum(new int[]{0, 4, 3, 0}, 0));
    }

    @Test
    public void test6() {
        TwoSumProblem sol = new TwoSumProblem();
        Assert.assertArrayEquals(new int[]{0, 2}, sol.twoSum(new int[]{-3,4,3,90}, 0));
    }
}
