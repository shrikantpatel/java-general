package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/combination-sum-iv/description/
 * <p>
 * This solution uses top‑down DFS with memoization.
 * It counts the number of ORDERED sequences that sum to the target.
 */
public class _377_Combination_Sum_IV {

    public int combinationSum4(int[] nums, int target) {

        // dp[remain] will store the number of ways to form "remain"
        // Using Integer (not int) so null means "not computed yet"
        Integer[] dp = new Integer[target + 1];

        return dfs(nums, target, dp);
    }

    /**
     * dfs(remain) returns the number of ordered sequences that sum to "remain".
     * <p>
     * Example:
     * remain = 4, nums = [1,2,3]
     * dfs(4) = dfs(3) + dfs(2) + dfs(1)
     */
    private int dfs(int[] nums, int remain, Integer[] dp) {

        // Base case: exact match → 1 valid sequence
        if (remain == 0) return 1;

        // Overshoot → no valid sequence
        if (remain < 0) return 0;

        // If already computed, return cached value
        if (dp[remain] != null) return dp[remain];

        int ways = 0;

        // Try every number as the next element in the sequence
        for (int num : nums) {
            // Reduce the target and recurse
            ways += dfs(nums, remain - num, dp);
        }

        // Store result to avoid recomputation
        dp[remain] = ways;

        return ways;
    }


// ------------------------------------------------------------
// JUnit 5 tests (no solution logic included)
// ------------------------------------------------------------
@Nested
class Tests {

    @Test
    void testExample1() {
        _377_Combination_Sum_IV solver = new _377_Combination_Sum_IV();
        int[] nums = {1, 2, 3};
        int target = 4;

        // Expected: 7
        // Explanation:
        // 1+1+1+1
        // 1+1+2
        // 1+2+1
        // 2+1+1
        // 2+2
        // 1+3
        // 3+1
        Assertions.assertEquals(7, solver.combinationSum4(nums, target));
    }

    @Test
    void testSingleElementExactMatch() {
        _377_Combination_Sum_IV solver = new _377_Combination_Sum_IV();
        int[] nums = {5};
        int target = 5;

        Assertions.assertEquals(1, solver.combinationSum4(nums, target));
    }

    @Test
    void testSingleElementNoMatch() {
        _377_Combination_Sum_IV solver = new _377_Combination_Sum_IV();
        int[] nums = {5};
        int target = 3;

        Assertions.assertEquals(0, solver.combinationSum4(nums, target));
    }

    @Test
    void testMultipleWays() {
        _377_Combination_Sum_IV solver = new _377_Combination_Sum_IV();
        int[] nums = {2, 3, 6, 7};
        int target = 7;

        // Valid sequences:
        // 2+2+3
        // 3+2+2
        // 2+3+2
        // 7
        Assertions.assertEquals(4, solver.combinationSum4(nums, target));
    }

    @Test
    void testZeroTarget() {
        _377_Combination_Sum_IV solver = new _377_Combination_Sum_IV();
        int[] nums = {1, 2, 3};
        int target = 0;

        // By definition: 1 way (choose nothing)
        Assertions.assertEquals(1, solver.combinationSum4(nums, target));
    }

    @Test
    void testEmptyNums() {
        _377_Combination_Sum_IV solver = new _377_Combination_Sum_IV();
        int[] nums = {};
        int target = 5;

        Assertions.assertEquals(0, solver.combinationSum4(nums, target));
    }
}
}