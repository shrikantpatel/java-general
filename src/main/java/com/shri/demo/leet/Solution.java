package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1395. Count Number of Teams
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * <p>
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * <p>
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rating = [2,5,3,4,1]
 * Output: 3
 * Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
 * Example 2:
 * <p>
 * Input: rating = [2,1,3]
 * Output: 0
 * Explanation: We can't form any team given the conditions.
 * Example 3:
 * <p>
 * Input: rating = [1,2,3,4]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == rating.length
 * 3 <= n <= 1000
 * 1 <= rating[i] <= 105
 * All the integers in rating are unique.
 * <p>
 * https://leetcode.com/problems/count-number-of-teams/discuss/775955/Understanding-the-question
 */
public class Solution {


    public int numTeams_Recursive(int[] rating) {

        int noOfTeams = 0;
        int len = rating.length;

        // find the team in forward direction
        for (int i = 0; i < len - 2; i++) {
            noOfTeams = noOfTeams + recursiveNumTeams(rating, i, 1, 1);
        }

        return noOfTeams;
    }

    private int recursiveNumTeams(int[] rating, int currentIndex, int totalThatMatchInForward, int totalThatMatchInBackward) {
        int len = rating.length;
        //if (totalThatMatchInForward == 3 && totalThatMatchInBackward == 3) return 2;
        if (totalThatMatchInForward == 3) {
            return 1;
        }
        if (totalThatMatchInBackward == 3) {
            return 1;
        }
        if (currentIndex == len - 1) {
            return 0;
        }
        int numOfTeams = 0;

        for (int i = currentIndex; i < len - 1; i++) {
            int forward = 0;
            int backward = 0;
            if (rating[currentIndex] < rating[i + 1]) {
                forward = 1;
            }
            if (rating[currentIndex] > rating[i + 1]) {
                backward = 1;
            }

            numOfTeams = numOfTeams + recursiveNumTeams(rating, i + 1, totalThatMatchInForward + forward, totalThatMatchInBackward + backward);
        }
        return numOfTeams;

    }

    @Test
    public void testScenario1() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numTeams_Recursive(new int[]{2, 5, 3, 4, 1}));
    }

    @Test
    public void testScenario2() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.numTeams_Recursive(new int[]{2, 1, 3}));
    }

    @Test
    public void testScenario3() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numTeams_Recursive(new int[]{1, 2, 3}));
    }

    @Test
    public void testScenario4() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.numTeams_Recursive(new int[]{1, 2, 3, 4}));
        // 1,2,3   1,3,4   1,2,4   2,3,4
    }

}
