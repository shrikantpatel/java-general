package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _409_Longest_Palindrome {

    public int longestPalindrome_1(String s) {

        Map<Character, Integer> charCounter = new HashMap<>();
        int result = 0;
        boolean singleChar = false;

        for (char c : s.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }

        for (int count : charCounter.values()) {
            result += (count / 2) * 2;
            if (count % 2 == 1) singleChar = true;
        }

        return singleChar ? result + 1 : result;
    }

    public int longestPalindrome_2(String s) {
        int[] freq = new int[128]; // Covers all ASCII characters
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int result = 0;
        for (int count : freq) {
            result += (count / 2) * 2;
        }

        // Add one if there's any odd count (center character)
        return result < s.length() ? result + 1 : result;
    }

    @Test
    public void testBasicPalindrome() {
        assertEquals(7, longestPalindrome_1("abccccdd")); // "dccaccd" or similar
        assertEquals(7, longestPalindrome_2("abccccdd")); // "dccaccd" or similar
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(1, longestPalindrome_1("a"));
        assertEquals(1, longestPalindrome_2("a"));
    }

    @Test
    public void testAllUniqueCharacters() {
        assertEquals(1, longestPalindrome_1("abcdef"));
        assertEquals(1, longestPalindrome_2("abcdef"));// Only one character can be center
    }

    @Test
    public void testEvenCountsOnly() {
        assertEquals(6, longestPalindrome_1("aabbcc"));
        assertEquals(6, longestPalindrome_2("aabbcc"));// All characters can be paired
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, longestPalindrome_1(""));
        assertEquals(0, longestPalindrome_2(""));
    }
}
