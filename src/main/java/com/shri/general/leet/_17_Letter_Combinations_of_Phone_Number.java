package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class _17_Letter_Combinations_of_Phone_Number {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        int currentIndex = 0;

        if (!digits.isEmpty()) buildPermutation("", currentIndex, ans, digits);

        return ans;
    }

    private void buildPermutation(String previousString, int currentIndex, List<String> ans, String digits) {

        // add the string to answer and retun if all the digits are accounted for.
        if (currentIndex >= digits.length()) {
            ans.add(previousString);
            return;
        }

        // get all the characters
        char[] allChars = getCharsForDigit(digits.charAt(currentIndex));

        for (char c : allChars) {
            buildPermutation(previousString + c, currentIndex+1, ans, digits);
        }
    }

    private char[] getCharsForDigit(char c) {

        return switch (c) {
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[0];
        };
    }

    @Test
    public void test1() {
        _17_Letter_Combinations_of_Phone_Number test = new _17_Letter_Combinations_of_Phone_Number();
        test.letterCombinations("23");
    }

    @Test
    public void test2() {
        _17_Letter_Combinations_of_Phone_Number test = new _17_Letter_Combinations_of_Phone_Number();
        assertEquals(new ArrayList<>(), test.letterCombinations(""));
    }

    @Test
    public void test3() {
        _17_Letter_Combinations_of_Phone_Number test = new _17_Letter_Combinations_of_Phone_Number();
        assertEquals(Arrays.asList("a", "b", "c"), test.letterCombinations("2"));
    }
}
