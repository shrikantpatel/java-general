/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * <p>
 * 76. Minimum Window Substring
 * Hard
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
package com.shri.general.leet;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _76_Minimum_Window_Substring {

    public String minWindow(String source, String searchString) {

        if (source == null || searchString == null) return "";

        source = source.trim();
        searchString = searchString.trim();

        int sourceLength = source.length();
        int searchStringLength = searchString.length();
        if (sourceLength == 0 || searchStringLength == 0 || searchStringLength > sourceLength) return "";

        int rightPointer = 0;
        int leftPointer = 0;
        int windowLength = Integer.MAX_VALUE;

        Set<Character> charSet = new HashSet<>();
        searchString.chars().forEach(c -> charSet.add((char) c));

        while (rightPointer < sourceLength) {

            // When the character exists in the source, remove it from the set
            charSet.remove(source.charAt(rightPointer));

            // We found all the characters
            while (charSet.isEmpty()) {

                // calculate the current window length
                windowLength = Math.min(windowLength, leftPointer - rightPointer + 1);

                // add the 1st character back
                charSet.add(source.charAt(rightPointer));

                // move the start pointer my one
                rightPointer++;

            }

            rightPointer++;
        }


        return "";

    }

    @Test
    void testExample1() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("BANC", obj.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void testExample2() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("a", obj.minWindow("a", "a"));
    }

    @Test
    void testExample3() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("", obj.minWindow("a", "aa"));
    }

    @Test
    void testNoMatch() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("", obj.minWindow("abc", "z"));
    }

    @Test
    void testTLongerThanS() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("", obj.minWindow("a", "abc"));
    }

    @Test
    void testEmptyS() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("", obj.minWindow("", "a"));
    }

    @Test
    void testEmptyT() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("", obj.minWindow("abc", ""));
    }
}
