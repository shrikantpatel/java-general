package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class _121_Best_Time_Buy_Sell_ {
    public int maxProfit_version1(int[] prices) {

        int result = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = i; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                result = temp > result ? temp : result;
            }
        }
        return result;

    }

    public int maxProfit_version2(int[] prices) {

        int maxProfit = 0;
        int lowestPrice = 0;

        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            maxProfit = Math.max(maxProfit, price-lowestPrice);
        }
        return maxProfit;

    }

    @Test
    public void test1() {

        _121_Best_Time_Buy_Sell_ obj = new _121_Best_Time_Buy_Sell_();
        int result = obj.maxProfit_version1(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result);
        Assert.assertEquals(5, result);

        result = obj.maxProfit_version2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test2() {
        _121_Best_Time_Buy_Sell_ obj = new _121_Best_Time_Buy_Sell_();

        int result = obj.maxProfit_version1(new int[]{7, 6, 4, 3, 1});
        System.out.println(result);
        Assert.assertEquals(0, result);

        result = obj.maxProfit_version2(new int[]{7, 6, 4, 3, 1});
        System.out.println(result);
        Assert.assertEquals(0, result);
    }
}
