package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * <p>
 * 424. Longest Repeating Character Replacement
 * <p>
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ABAB", k = 2L
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * <p>
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class _424_Longest_Repeating_Character_Replacement {


    public int characterReplacement(String s, int k) {
        // Array to store frequency of each uppercase letter in the current window
        int[] count = new int[26];

        // maxCount keeps track of the count of the most frequent character in the window
        int maxCount = 0;

        // maxLength stores the length of the longest valid window found
        int maxLength = 0;

        // Left pointer of the sliding window
        int left = 0;

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {

            // Increment the count of the current character
            count[s.charAt(right) - 'A']++;

            // Update maxCount to reflect the most frequent character in the window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If the number of characters to replace exceeds k, shrink the window from the left
            while (right - left + 1 - maxCount > k) {
                // Decrease the count of the character going out of the window
                count[s.charAt(left) - 'A']--;
                left++; // Move the left pointer forward
            }

            // Update maxLength with the size of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the length of the longest valid substring
        return maxLength;
    }


    @Test
    void testCase1() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(4, solution.characterReplacement("ABAB", 2));
    }

    @Test
    void testCase2() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }

    @Test
    void testCase3() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(5, solution.characterReplacement("AAAAA", 2));
    }

    @Test
    void testCase4() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(3, solution.characterReplacement("ABCDE", 2));
    }

    @Test
    void testCase5() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(9, solution.characterReplacement("AABABBAAABBB", 3));
    }

    @Test
    void testCase7() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(5, solution.characterReplacement("ABDDD", 2));
    }

    @Test
    void testCase6() {
        _424_Longest_Repeating_Character_Replacement solution = new _424_Longest_Repeating_Character_Replacement();
        Assertions.assertEquals(4, solution.characterReplacement("ABBB", 2));
    }
}
