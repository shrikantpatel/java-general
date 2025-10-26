package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * 70. Climbing Stairs
 * Easy
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class _70_Climbing_Staris {

    // Recursive approach
    public int climbStairs_1(int n) {

        if (n <= 2) return n;
        return climbStairs_1(n - 1) + climbStairs_1(n - 2);
    }

    // Dynamic Programming approach
    public int climbStairs_2(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    @Test
    public void testBaseCases() {
        assertEquals(1, climbStairs_1(1));
        assertEquals(2, climbStairs_1(2));
        assertEquals(1, climbStairs_2(1));
        assertEquals(2, climbStairs_2(2));
    }

    @Test
    public void testSmallInputs() {
        assertEquals(3, climbStairs_1(3)); // 1+1+1, 1+2, 2+1
        assertEquals(5, climbStairs_1(4)); // 5 distinct ways
        assertEquals(3, climbStairs_2(3)); // 1+1+1, 1+2, 2+1
        assertEquals(5, climbStairs_2(4)); // 5 distinct ways
    }

    @Test
    public void testMediumInput() {
        assertEquals(13, climbStairs_1(6)); // Confirmed earlier
        assertEquals(13, climbStairs_2(6)); // Confirmed earlier
    }

    @Test
    public void testLargerInput() {
        // This will be slow due to recursion; consider memoization for n > 30
        assertEquals(89, climbStairs_1(10));
        assertEquals(89, climbStairs_2(10));
    }

    @Test
    public void testHighInput_n30() {
        assertEquals(1346269, climbStairs_1(30));
        assertEquals(1346269, climbStairs_2(30));
    }

    @Test
    public void testHighInput_n35() {
        assertEquals(14930352, climbStairs_1(35));
        assertEquals(14930352, climbStairs_2(35));
    }


}
