package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _416_Partition_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {

        if (nums.length == 0) return false;

        // if the sum is odd, then we cannot partition it to 2 parts.
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // single number > the sum/2 we cannot partition
        if (nums[nums.length - 1] > target) return false;

        boolean[] dp = new boolean[target + 1];

        /**
         * The DP (dynamic programming) approach uses a boolean array dp where dp[i] is true if a subset sum of i is possible with the given numbers.
         * dp[0] is always true (empty subset).
         * For each number, iterate backwards from target to num, updating dp[i] = dp[i] || dp[i - num].
         * This means: if a sum of i - num was possible before, then a sum of i is now possible by adding num.
         * At the end, if dp[target] is true, a subset with sum target exists, so the array can be partitioned.
         */
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }


    @Test
    void testCanPartition() {
        _416_Partition_Equal_Subset_Sum solver = new _416_Partition_Equal_Subset_Sum();

        assertTrue(solver.canPartition(new int[]{1, 5, 11, 5}));
        assertFalse(solver.canPartition(new int[]{1, 2, 3, 5}));
        assertTrue(solver.canPartition(new int[]{2, 2, 1, 1}));
        assertTrue(solver.canPartition(new int[]{1, 1, 3, 4, 7}));
        assertTrue(solver.canPartition(new int[]{1, 6, 6, 11}));
        assertFalse(solver.canPartition(new int[]{1, 6, 6, 7}));
        assertTrue(solver.canPartition(new int[]{1, 3, 4, 12, 14}));
        assertTrue(solver.canPartition(new int[]{1, 3, 4, 12, 14}));
    }

}
