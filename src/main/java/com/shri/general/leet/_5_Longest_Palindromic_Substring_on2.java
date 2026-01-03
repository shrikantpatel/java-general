package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class _5_Longest_Palindromic_Substring_on2 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // odd-length center
            int len2 = expand(s, i, i + 1);   // even-length center
            int len = Math.max(len1, len2);

            if (len > end - start) {
                end = i + len / 2;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    @Test
    public void test1() {
        assertEquals("aba", new _5_Longest_Palindromic_Substring_on2().longestPalindrome("babad"));
    }

    @Test
    public void test2() {
        assertEquals("bb", new _5_Longest_Palindromic_Substring_on2().longestPalindrome("cbbd"));
    }

    @Test
    public void test3() {
        assertEquals("bcb", new _5_Longest_Palindromic_Substring_on2().longestPalindrome("abcabcbb"));
    }

    @Test
    public void test4() {
        assertEquals("a", new _5_Longest_Palindromic_Substring_on2().longestPalindrome("a"));
    }

    @Test
    public void test5() {
        assertEquals("bb", new _5_Longest_Palindromic_Substring_on2().longestPalindrome("bb"));
    }
}
