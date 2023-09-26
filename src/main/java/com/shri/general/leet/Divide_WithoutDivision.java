package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/divide-two-integers/
 * 29. Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 * <p>
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * <p>
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 * <p>
 * Constraints:
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 **/
public class Divide_WithoutDivision {

    public int divide(int dividend, int divisor) {

        int result = 0;
        int dividendAbs = -1*Math.abs(dividend);
        int divisorAbs = -1*Math.abs(divisor);

        //edge condition
        if (dividend == Integer.MIN_VALUE && divisor ==-1) {
            return Integer.MAX_VALUE;
        }

        while (dividendAbs <= divisorAbs) {
            result++;
            dividendAbs = dividendAbs - divisorAbs;
        }

        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            result = result * -1;
        }
        return result;
    }

    @Test
    public void test1(){
        Assert.assertEquals(3, (new Divide_WithoutDivision()).divide(10, 3));
    }

    @Test
    public void test2(){
        Assert.assertEquals(2147483647, (new Divide_WithoutDivision()).divide(-2147483648, -1));
    }

    @Test
    public void test3(){
        Assert.assertEquals(-2147483648, (new Divide_WithoutDivision()).divide(-2147483648, 1));
    }

    @Test
    public void test4(){
        Assert.assertEquals(-1073741824, (new Divide_WithoutDivision()).divide(-2147483648, 2));
    }

    @Test
    public void test5(){
        Assert.assertEquals(-2147483647, (new Divide_WithoutDivision()).divide(2147483647, -1));
    }

}


