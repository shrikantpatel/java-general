package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
523. Continuous Subarray Sum

Given a list of non-negative numbers and a target integer k, write a function to check if the array has a
continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to
n*k where n is also an integer.



Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.


Constraints:

The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class Continuous_Subarray_Sum {

    //Time Limit Exceeded
    public boolean checkSubarraySum1(int[] nums, int k) {

        int size = nums.length;
        int[] sums = new int[size];

        for (int i = 0; i < size; i++) {
            sums[i] = nums[i];
            for (int j = 0; j < i; j++) {
                sums[j] = nums[i] + sums[j];
                if (k == 0 && sums[j] == k) {
                    //System.out.println(sums[j]);
                    return true;
                } else if (k != 0 && sums[j] % k == 0) {
                    //System.out.println(sums[j]);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int preMod = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if (set.contains(mod)) {
                return true;
            }
            set.add(preMod);
            preMod = mod;
        }
        return false;
    }

    @Test
    public void test1() {
        Continuous_Subarray_Sum toTest = new Continuous_Subarray_Sum();
        Assert.assertEquals(true, toTest.checkSubarraySum(new int[]{23, 2, 2, 4, 6, 7}, 6));
    }

    @Test
    public void test2() {
        Continuous_Subarray_Sum toTest = new Continuous_Subarray_Sum();
        Assert.assertEquals(true, toTest.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }

    @Test
    public void test5() {
        Continuous_Subarray_Sum toTest = new Continuous_Subarray_Sum();
        Assert.assertEquals(true, toTest.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }

    @Test
    public void test3() {
        Continuous_Subarray_Sum toTest = new Continuous_Subarray_Sum();
        Assert.assertEquals(false, toTest.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 0));
    }

    @Test
    public void test4() {
        Continuous_Subarray_Sum toTest = new Continuous_Subarray_Sum();
        Assert.assertEquals(true, toTest.checkSubarraySum(new int[]{0, 0}, 0));
    }
}
