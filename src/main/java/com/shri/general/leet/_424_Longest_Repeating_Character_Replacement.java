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

        int length = s.length();

        // zero length or negative k means no replacement can be done
        if (length == 0 || k < 0) return 0;

        int start = 0, end = 0, replacmentCounter = 0, maxLength = 0;

        for (start = 0; start < length; start++) {

            for (end = start; end < length; end++) {
                // if the characters are same, continue
                if (s.charAt(start) == s.charAt(end)) continue;

                // if the characters are different, increment the replacement counter
                replacmentCounter++;

                // if the replacement counter exceeds k, break the loop
                if (replacmentCounter > k) {
                    break;
                }
            }

            // calculate the max length of the substring
            maxLength = Math.max(maxLength, end - start);

        }

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
}
