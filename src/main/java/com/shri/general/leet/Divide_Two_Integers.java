package com.shri.general.leet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/*
29. Divide Two Integers

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:
Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
*/

@RunWith(MockitoJUnitRunner.class)
public class Divide_Two_Integers {

    public int divide_Approach1(int dividend, int divisor) {
        //get the absolute value
        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);
        int quotient = 0;

        while (dividendAbs - divisorAbs >= 0) {
            quotient++;
            dividendAbs = dividendAbs - divisorAbs;
        }

        /*
        since we used absolute value, if either dividend and divisor is -ve, then final ans
        should be -ve
         */
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) quotient = -quotient;
        return quotient == Integer.MIN_VALUE ? Integer.MAX_VALUE : quotient;
    }

    public int divide_Approach2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        int quotient = 0;

        //get the absolute value
        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);

        while (dividendAbs >= divisorAbs) {
            int powerOfTwo = 1;
            int value = divisorAbs;

            while (value + value < dividendAbs) {
                value = value + value;
                powerOfTwo = powerOfTwo + powerOfTwo;
            }
            quotient = quotient + powerOfTwo;
            dividendAbs = dividendAbs - value;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) quotient = -quotient;
        return quotient == Integer.MIN_VALUE ? Integer.MAX_VALUE : quotient;
    }

    @Test
    public void testScenario1() {
        Divide_Two_Integers test = new Divide_Two_Integers();
        assertEquals(3, test.divide_Approach1(10, 3));
        assertEquals(3, test.divide_Approach2(10, 3));
    }

    @Test
    public void testScenario2() {
        Divide_Two_Integers test = new Divide_Two_Integers();
        assertEquals(-2, test.divide_Approach1(7, -3));
        assertEquals(-2, test.divide_Approach2(7, -3));
    }

    @Test
    public void testScenario3() {
        Divide_Two_Integers test = new Divide_Two_Integers();
        assertEquals(1, test.divide_Approach1(1, 1));
        assertEquals(1, test.divide_Approach2(1, 1));
    }

    @Test
    public void testScenario4() {
        Divide_Two_Integers test = new Divide_Two_Integers();
        assertEquals(2147483647, test.divide_Approach1(-2147483648, -1));
        assertEquals(2147483647, test.divide_Approach2(-2147483648, -1));
    }

    @Test
    public void testScenario5() {
        Divide_Two_Integers test = new Divide_Two_Integers();
        assertEquals(596, test.divide_Approach1(93706, 157));
        assertEquals(596, test.divide_Approach1(93706, 157));
    }
}
