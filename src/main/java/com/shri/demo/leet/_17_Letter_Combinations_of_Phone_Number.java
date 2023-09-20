package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_Letter_Combinations_of_Phone_Number {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        String prefix = "";
        int currentIndex = 0;

        if (digits.length() > 0) buildPermutation(prefix, currentIndex, ans, digits);

        return ans;
    }

    private void buildPermutation(String previousString, int currentIndex, List<String> ans, String digits) {

        char[] charArray = getCharsForDigit(digits.charAt(currentIndex));

        for (char c : charArray) {
            // if we are last digit, we add to previousString and add it to answer
            if (currentIndex == digits.length() - 1) {
                ans.add(previousString + c);
            }
            // else we continue to add it to prviousString and continue to build permutation
            else {
                buildPermutation(previousString + c, currentIndex + 1, ans, digits);
            }
        }
    }

    private char[] getCharsForDigit(char c) {

        switch (c) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
        }
        return new char[0];
    }

    @Test
    public void test1() {
        _17_Letter_Combinations_of_Phone_Number test = new _17_Letter_Combinations_of_Phone_Number();
        test.letterCombinations("23");
    }

    @Test
    public void test2() {
        _17_Letter_Combinations_of_Phone_Number test = new _17_Letter_Combinations_of_Phone_Number();
        Assert.assertEquals(new ArrayList<>(), test.letterCombinations(""));
    }

    @Test
    public void test3() {
        _17_Letter_Combinations_of_Phone_Number test = new _17_Letter_Combinations_of_Phone_Number();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), test.letterCombinations("2"));
    }
}
