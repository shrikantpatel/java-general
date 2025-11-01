package com.shri.general.leet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


/**
 * https://leetcode.com/problems/coin-change/
 */
public class _322_Coin_Change {

    public int coinChange(int[] coins, int amount) {

        // Create a DP array where dp[i] represents the minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initialize all entries with a sentinel value (amount + 1), which is effectively "infinity"
        // This ensures any valid solution will be smaller than this value
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;

        // Iterate over each coin denomination
        for (int coin : coins) {

            // For each coin, update the dp array for all amounts from coin to target amount
            for (int i = coin; i < amount+1; i++) {

                // If we can make amount (i - coin), then we can make amount i by adding one more coin
                // Take the minimum between current dp[i] and the new possibility dp[i - coin] + 1
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still the sentinel value, it means no combination of coins can make the amount
        // Return -1 in that case; otherwise return the computed minimum number of coins
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 🧪 Embedded JUnit 5 test class
    public static class CoinChangeTests {

        private final _322_Coin_Change solver = new _322_Coin_Change();

        @Test
        public void testBasicCase() {
            int[] coins = {1, 2, 5};
            int amount = 11;
            assertEquals(3, solver.coinChange(coins, amount));
        }

        @Test
        public void testExactMatch() {
            int[] coins = {2, 3, 7};
            int amount = 14;
            assertEquals(2, solver.coinChange(coins, amount));
        }

        @Test
        public void testNoSolution() {
            int[] coins = {2};
            int amount = 3;
            assertEquals(-1, solver.coinChange(coins, amount));
        }

        @Test
        public void testZeroAmount() {
            int[] coins = {1, 2, 5};
            int amount = 0;
            assertEquals(0, solver.coinChange(coins, amount));
        }

        @Test
        public void testSingleCoinType() {
            int[] coins = {4};
            int amount = 12;
            assertEquals(3, solver.coinChange(coins, amount));
        }

        @Test
        public void testLargeAmount() {
            int[] coins = {1, 2, 5};
            int amount = 100;
            assertEquals(20, solver.coinChange(coins, amount));
        }

        @Test
        public void testUnsortedCoins() {
            int[] coins = {5, 1, 2};
            int amount = 11;
            assertEquals(3, solver.coinChange(coins, amount));
        }
    }
}
