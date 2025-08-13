package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * <p>
 * <a href="https://leetcode.com/problems/valid-anagram/description/">...</a>
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * <p>
 * Output: false
 */
public class _242_Valid_Anagram {


    public boolean isAnagram(String firstString, String secondString) {

        // If the strings are of different lengths, they can't be anagrams
        if (firstString.length() != secondString.length()) return false;

        // Map to store character counts from the first string
        Map<Character, Integer> counts = new HashMap<>();

        // Count each character in the first string
        for (char c : firstString.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Subtract the count for each character found in the second string
        for (char c : secondString.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) - 1);
            // If count goes negative, second string has extra characters
            if (counts.get(c) < 0) return false;
        }

        // Final check to ensure all counts are zero
        for (int counter : counts.values()) {
            if (counter > 0) return false; // Extra characters in first string
        }

        // All character counts matched; strings are anagrams
        return true;
    }

    @Test
    void returnsTrueForValidAnagram() {
        _242_Valid_Anagram solver = new _242_Valid_Anagram();
        Assertions.assertTrue(solver.isAnagram("anagram", "nagaram"));
    }

    @Test
    void returnsFalseForNonAnagram() {
        _242_Valid_Anagram solver = new _242_Valid_Anagram();
        Assertions.assertFalse(solver.isAnagram("rat", "car"));
    }

    @Test
    void returnsTrueForEmptyStrings() {
        _242_Valid_Anagram solver = new _242_Valid_Anagram();
        Assertions.assertTrue(solver.isAnagram("", ""));
    }

    @Test
    void returnsFalseForDifferentLengths() {
        _242_Valid_Anagram solver = new _242_Valid_Anagram();
        Assertions.assertFalse(solver.isAnagram("a", "ab"));
    }

    @Test
    void returnsTrueForSingleCharacter() {
        _242_Valid_Anagram solver = new _242_Valid_Anagram();
        Assertions.assertTrue(solver.isAnagram("a", "a"));
    }

    @Test
    void returnsFalseForDuplicatedChar() {
        _242_Valid_Anagram solver = new _242_Valid_Anagram();
        Assertions.assertFalse(solver.isAnagram("aa", "a"));
    }

}
