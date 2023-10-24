package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
8. String to Integer (atoi)

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 */
public class String_to_Integer {


    public int myAtoi(String str) {

        boolean numberStart = false;
        str = str.trim();
        StringBuilder strbuff = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // integral part has not started
            if (!numberStart) {

                // if initial space ignore it
                if (c == ' ') continue;

                // hit first integer, -, +
                if (c == '+' || c == '-' || (c >= 47 && c <= 57)) {
                    numberStart = true;
                    strbuff.append(c);
                }
                // if the initial character are neither -, +, integer, it not valid format
                else {
                    return 0;
                }
            }
            // if integral part has started only consider integer from that point onwards
            // if you get anything else discontinue parsing
            else {
                if (c >= 47 && c <= 57) {
                    strbuff.append(c);
                } else {
                    break;
                }
            }
        }

        int answer = 0;
        if (numberStart) {

            String finalString = strbuff.toString();

            switch (finalString) {
                case "-":
                case "+":
                    break;
                default:
                    try {
                        answer = Integer.parseInt(new String(strbuff));
                    } catch (NumberFormatException nme) {
                        if (finalString.contains("-")) return Integer.MIN_VALUE;
                        else return Integer.MAX_VALUE;
                    }
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertEquals(90, (new String_to_Integer()).myAtoi("90"));
    }

    @Test
    public void test2() {
        assertEquals(-42, (new String_to_Integer()).myAtoi("   -42"));
    }

    @Test
    public void test3() {
        assertEquals(0, (new String_to_Integer()).myAtoi("words and 987"));
    }

    @Test
    public void test4() {
        assertEquals(4193, (new String_to_Integer()).myAtoi("4193 with words"));
    }

    @Test
    public void test5() {
        assertEquals(Integer.MIN_VALUE, (new String_to_Integer()).myAtoi("-91283472332"));
    }

    @Test
    public void test6() {
        assertEquals(0, (new String_to_Integer()).myAtoi(""));
    }

    @Test
    public void test7() {
        assertEquals(0, (new String_to_Integer()).myAtoi("+"));
    }

    @Test
    public void test8() {
        assertEquals(0, (new String_to_Integer()).myAtoi("-"));
    }

    @Test
    public void test9() {
        assertEquals(0, (new String_to_Integer()).myAtoi("+-2"));
    }

    @Test
    public void test10() {
        assertEquals(0, (new String_to_Integer()).myAtoi("-+2"));
    }

    @Test
    public void test11() {
        assertEquals(0, (new String_to_Integer()).myAtoi("  +0 123"));
    }

    @Test
    public void test12() {
        assertEquals(2147483647, (new String_to_Integer()).myAtoi("2147483648"));
    }

    @Test
    public void test13() {
        assertEquals(2147483647, (new String_to_Integer()).myAtoi("2147483800"));
    }

    @Test
    public void test14() {
        assertEquals(0, (new String_to_Integer()).myAtoi("-   234"));
    }

    @Test
    public void test15() {
        assertEquals(0, (new String_to_Integer()).myAtoi("         "));
    }

}
