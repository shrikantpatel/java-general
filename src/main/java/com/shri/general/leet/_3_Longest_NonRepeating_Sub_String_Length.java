package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * 36.8K
 * 1.7K
 * Companies
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class _3_Longest_NonRepeating_Sub_String_Length {
    public static int solution(String str) {

        /**
         * Use the sliding window
         */
        char[] input = str.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();

        // variable to store the start index and end index
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (char c : input) {

            if (!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
            // when current char exists in set, it duplicate and we need to slide the window
            else {

                // check the current end and if its greater than maxlength, we have got new maxlength.
                maxLength = Math.max(endIndex - startIndex, maxLength);

                // slide the window, start from start index, continue to move right till hit the repeating character
                // as you moving through remove all element that you encounter on the way from set,
                // since they need to discarded from subsequent unique char check
                while (str.charAt(startIndex) != c) {
                    uniqueChars.remove(str.charAt(startIndex));
                    startIndex++;
                }
                // last loop stop at exactly when we encounter repeating character
                // so we need to increment start index by 1 to get to next character index.
                startIndex++;
            }
            endIndex++;
        }
        maxLength = Math.max(endIndex - startIndex, maxLength);

        return maxLength;
    }

    @Test
    public void test1() {
        assertEquals(4, _3_Longest_NonRepeating_Sub_String_Length.solution("nndNfdfdf"));
    }

    @Test
    public void test2() {
        assertEquals(3, _3_Longest_NonRepeating_Sub_String_Length.solution("dvdf"));
    }

    @Test
    public void test3() {
        assertEquals(3, _3_Longest_NonRepeating_Sub_String_Length.solution("abcabcbb"));
    }

    @Test
    public void test4() {
        assertEquals(1, _3_Longest_NonRepeating_Sub_String_Length.solution("bbbbb"));
    }

    @Test
    public void test5() {
        assertEquals(3, _3_Longest_NonRepeating_Sub_String_Length.solution("pwwkew"));
    }

}
