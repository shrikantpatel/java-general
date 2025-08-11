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

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _76_Minimum_Window_Substring {

    public String minWindow(String source, String searchString) {

        if (source == null || searchString == null) return "";

        int sourceLength = source.length(), searchStringLength = searchString.length();
        if (sourceLength == 0 || searchStringLength == 0 || searchStringLength > sourceLength) return "";

        int leftPointer = 0, charFoundCount = 0, windowLength = Integer.MAX_VALUE;
        String answer = "";

        HashMap<Character, Integer> charNeeded = new HashMap<>();
        for (char c : searchString.toCharArray()) {
            charNeeded.put(c, charNeeded.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> charInCurrentWindow = new HashMap<>();

        for (int rightPointer = 0; rightPointer < sourceLength; rightPointer++) {

            char currentChar = source.charAt(rightPointer);
            charInCurrentWindow.put(currentChar, charInCurrentWindow.getOrDefault(currentChar, 0) + 1);

            if (charNeeded.containsKey(currentChar) && charInCurrentWindow.get(currentChar) == charNeeded.get(currentChar)) {
                charFoundCount++;
            }

            while (charFoundCount == charNeeded.size()) {

                // If the current window size is smaller than the previously found minimum,
                // update the minimum window length and store the current window substring as the answer.
                if (windowLength > (rightPointer - leftPointer + 1)) {
                    windowLength = rightPointer - leftPointer + 1;
                    answer = source.substring(leftPointer, rightPointer + 1);
                }

                char leftChar = source.charAt(leftPointer);
                charInCurrentWindow.put(leftChar, charInCurrentWindow.get(leftChar) - 1);

                // If the character at the left pointer is required and its count in the current window
                // drops below the required count after moving the left pointer, decrement charFoundCount.
                // This indicates that the window no longer contains all required instances of this character.
                if (charNeeded.containsKey(leftChar) && charInCurrentWindow.get(leftChar) < charNeeded.get(leftChar)) {
                    charFoundCount--;
                }

                leftPointer++;
            }
        }

        return answer;
    }

    @Test
    void testDoubleA() {
        _76_Minimum_Window_Substring obj = new _76_Minimum_Window_Substring();
        assertEquals("aa", obj.minWindow("aa", "aa"));
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
