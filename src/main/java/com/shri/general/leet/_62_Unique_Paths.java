package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class _62_Unique_Paths {

    public int uniquePaths(int m, int n) {

        // Edge case: empty grid
        if (m == 0 && n == 0) return 0;

        // Initialize a DP table where dp[i][j] represents the number of paths to cell (i, j)
        int[][] dp = new int[m][n];

        // Fill the first column with 1s: only one way to reach any cell in the first column (all downs)
        for (int row = 0; row < m; row++) dp[row][0] = 1;

        // Fill the first row with 1s: only one way to reach any cell in the first row (all rights)
        for (int col = 0; col < n; col++) dp[0][col] = 1;

        // Fill the rest of the table using the recurrence:
        // dp[i][j] = dp[i-1][j] (from above) + dp[i][j-1] (from left)
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] // one cessll from above
                        + dp[row][col - 1]; // one cell from left
            }
        }

        // Return the value in the bottom-right corner
        return dp[m - 1][n - 1];

    }

    @Test
    public void testUniquePaths_3x3() {
        _62_Unique_Paths solver = new _62_Unique_Paths();
        int result = solver.uniquePaths(3, 3);
        assertEquals(6, result, "Expected 6 unique paths for a 3x3 grid");
    }

    @Test
    public void testUniquePaths_1x1() {
        _62_Unique_Paths solver = new _62_Unique_Paths();
        int result = solver.uniquePaths(1, 1);
        assertEquals(1, result, "Expected 1 unique path for a 1x1 grid");
    }

    @Test
    public void testUniquePaths_3x2() {
        _62_Unique_Paths solver = new _62_Unique_Paths();
        int result = solver.uniquePaths(3, 2);
        assertEquals(3, result, "Expected 3 unique paths for a 3x2 grid");
    }
}