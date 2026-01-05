package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class _8_String_to_Integer {

    public int myAtoi(String s) {

// If the input string is null or only contains whitespace, return 0 immediately
        if (s == null || s.isBlank()) return 0;

// Trim leading/trailing spaces and convert to a char array for easier processing
        char[] input = s.trim().toCharArray();

        // Sign calculation
        int sign = 1;
        if (input[0] == '-') sign = -1;

        // If the first character is either '+' or '-', skip it by moving counter forward
        int counter = 0;
        if (input[0] == '-' || input[0] == '+') counter = 1;

        // Use a long to accumulate the result so we can detect overflow before casting to int
        long result = 0;

        // Process characters while they are digits
        while (counter < input.length && Character.isDigit(input[counter])) {

            // Convert current digit character to its numeric value
            int digit = input[counter] - '0';

            // Build the number by shifting previous result and adding the new digit
            result = result * 10 + digit;

            // Clamp overflow: if result exceeds int range, return max/min accordingly
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            counter++;
        }

        return (int) (sign * result);
    }

    @Test
    void testSimplePositiveNumber() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(42, solver.myAtoi("42"));
    }

    @Test
    void testLeadingSpacesAndNegative() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(-42, solver.myAtoi("   -42"));
    }

    @Test
    void testWithWordsAfterNumber() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(4193, solver.myAtoi("4193 with words"));
    }

    @Test
    void testInvalidLeadingCharacters() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(0, solver.myAtoi("words and 987"));
    }

    @Test
    void testOverflowPositive() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(Integer.MAX_VALUE, solver.myAtoi("91283472332"));
    }

    @Test
    void testOverflowNegative() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(Integer.MIN_VALUE, solver.myAtoi("-91283472332"));
    }

    @Test
    void testEmptyString() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(0, solver.myAtoi(""));
    }

    @Test
    void testOnlySpaces() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(0, solver.myAtoi("     "));
    }

    @Test
    void testPlusSign() {
        _8_String_to_Integer solver = new _8_String_to_Integer();
        assertEquals(123, solver.myAtoi("+123"));
    }


}
