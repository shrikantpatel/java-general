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
public class Count_Number_of_Teams {

    public int numTeams(int[] rating) {
        int length = rating.length;
        int answer = 0;

        for (int currentIndex = 0; currentIndex < length; currentIndex++) {

            int leftAsc = 0, rightAsc = 0, leftDesc = 0, rightDesc = 0;

            for (int leftOfCurrentIndex = 0; leftOfCurrentIndex < currentIndex; leftOfCurrentIndex++) {
                if (rating[leftOfCurrentIndex] < rating[currentIndex]) leftAsc++;
                else if (rating[leftOfCurrentIndex] > rating[currentIndex]) leftDesc++;
            }

            for (int rightOfCurrentIndex = currentIndex + 1; rightOfCurrentIndex < length; rightOfCurrentIndex++) {
                if (rating[rightOfCurrentIndex] > rating[currentIndex]) rightAsc++;
                else if (rating[rightOfCurrentIndex] < rating[currentIndex]) rightDesc++;

            }

            answer += (leftDesc * rightDesc + leftAsc * rightAsc);
        }
        return answer;
    }

    @Test
    public void testScenario1() {
        Count_Number_of_Teams s = new Count_Number_of_Teams();
        Assert.assertEquals(3, s.numTeams(new int[]{2, 5, 3, 4, 1}));
        //(2,3,4), (5,4,1), (5,3,1)
    }

    @Test
    public void testScenario1a() {
        Count_Number_of_Teams s = new Count_Number_of_Teams();
        Assert.assertEquals(9, s.numTeams(new int[]{2, 5, 3, 4, 1, 0}));
        //(2,3,4) (5,3,1) (5,4,1) (5,3,0) (5,4,0) (5,1,0) (3,1,0) (4,1,0) (2,1,0)
    }

    @Test
    public void testScenario2() {
        Count_Number_of_Teams s = new Count_Number_of_Teams();
        Assert.assertEquals(0, s.numTeams(new int[]{2, 1, 3}));
    }

    @Test
    public void testScenario3() {
        Count_Number_of_Teams s = new Count_Number_of_Teams();
        Assert.assertEquals(1, s.numTeams(new int[]{1, 2, 3}));
    }

    @Test
    public void testScenario4() {
        Count_Number_of_Teams s = new Count_Number_of_Teams();
        Assert.assertEquals(10, s.numTeams(new int[]{1, 2, 3, 4, 5}));
        // 1,2,3    1,2,4   1,3,4   1,2,5   1,3,5   1,4,5   2,3,4   2,3,5   2,4,5   3,4,5
    }

}
