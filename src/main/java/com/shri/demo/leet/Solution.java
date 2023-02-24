package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
*/
public class Solution {

    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        while (counter < nums.length - 1) {
            if (nums[counter] == nums[counter + 1]) break;
            counter++;
        }

        return nums[counter];
    }

    public int findDuplicate2(int[] nums) {

        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.contains(num)) {
                return num;
            }
            unique.add(num);
        }
        return -1;
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] input = new int[]{1, 3, 4, 2, 2};
        Assert.assertEquals(2, solution.findDuplicate1(input));
        Assert.assertEquals(2, solution.findDuplicate2(input));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] input = new int[]{3, 1, 3, 4, 2};
        Assert.assertEquals(3, solution.findDuplicate1(input));
        Assert.assertEquals(3, solution.findDuplicate2(input));
    }
}
