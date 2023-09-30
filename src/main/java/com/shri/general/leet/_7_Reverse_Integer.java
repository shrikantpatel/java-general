package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 7. Reverse Integer
 * Medium
 * 11.8K
 * 12.9K
 * Companies
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * <p>
 * Constraints:
 * -231 <= x <= 231 - 1
 */
public class _7_Reverse_Integer {

    public int reverse1(int x) {
        int ans = 0;
        StringBuffer sb = new StringBuffer(Integer.toString(x));
        try {
            if (x < 0) {
                sb.delete(0, 1);
                ans = Integer.parseInt(sb.reverse().toString()) * -1;
            } else {
                ans = Integer.parseInt(sb.reverse().toString());
            }
        } catch (NumberFormatException e) {
            ans = 0;
        }

        return ans;
    }

    public int reverse2(int x) {
        long ans = 0;
        int quotient = x;
        int reminder = 0;

        while (quotient != 0) {
            reminder = quotient % 10;
            quotient = quotient / 10;
            System.out.println(ans);
            ans = ans * 10 + reminder;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE ) {
                return 0;
            }

        }
        return (int)ans;
    }

    @Test
    public void test1() {
        _7_Reverse_Integer test = new _7_Reverse_Integer();
        //Assert.assertEquals(321,test.reverse1(123));
        Assert.assertEquals(321, test.reverse2(123));
    }

    @Test
    public void test2() {
        _7_Reverse_Integer test = new _7_Reverse_Integer();
        //Assert.assertEquals(-321,test.reverse1(-123));
        Assert.assertEquals(-321, test.reverse2(-123));
    }

    @Test
    public void test2_1() {
        _7_Reverse_Integer test = new _7_Reverse_Integer();
        //Assert.assertEquals(-321,test.reverse1(-123));
        Assert.assertEquals(-4321, test.reverse2(-1234));
    }

    @Test
    public void test3() {
        _7_Reverse_Integer test = new _7_Reverse_Integer();
        //Assert.assertEquals(21,test.reverse1(120));
        Assert.assertEquals(21, test.reverse2(120));
    }

    @Test
    public void test4() {
        _7_Reverse_Integer test = new _7_Reverse_Integer();
        //Assert.assertEquals(0,test.reverse1(1534236469));
        Assert.assertEquals(0, test.reverse2(1534236469));
    }

}
