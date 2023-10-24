package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 5. Longest Palindromic Substring
 * Medium
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class _5_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        String longestStr = "";

        if (s.length() == 1) return s;

        // pointer from start
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {

            // pointer from other end going till end of th list
            for (int endIndex = s.length(); endIndex > startIndex; endIndex--) {

                // algo optimization 1
                // if the length of the string from start to end < max length then break, no point in checking further
                // we already found the longest palindrome
                int length = endIndex - startIndex;
                if (length < longestStr.length()) break;

                // algo optimization 2
                // if the first and last character done match not need to check for palindrome
                if (sb.charAt(startIndex) == sb.charAt(endIndex - 1)) {
                    String temp = sb.substring(startIndex, endIndex);
                    if (isPalindrome(temp)) {
                        longestStr = longestStr.length() >= length ? longestStr : temp;
                    }
                }
            }
        }
        return longestStr;
    }

    public boolean isPalindrome(String input) {
        if (input.length() == 0) return false;
        else {
            if (new StringBuilder(input).reverse().toString().equals(input)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        assertEquals("bab", new _5_Longest_Palindromic_Substring().longestPalindrome("babad"));
    }

    @Test
    public void test2() {
        assertEquals("bb", new _5_Longest_Palindromic_Substring().longestPalindrome("cbbd"));
    }

    @Test
    public void test3() {
        assertEquals("bcb", new _5_Longest_Palindromic_Substring().longestPalindrome("abcabcbb"));
    }

    @Test
    public void test4() {
        assertEquals("a", new _5_Longest_Palindromic_Substring().longestPalindrome("a"));
    }

    @Test
    public void test5() {
        assertEquals("bb", new _5_Longest_Palindromic_Substring().longestPalindrome("bb"));
    }
}
