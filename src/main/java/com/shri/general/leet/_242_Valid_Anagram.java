package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        if (firstString.length() != secondString.length()) return false;
        int[] counts = new int[26];

        for (int i = 0; i < firstString.length(); i++) {
            counts[firstString.charAt(i) - 'a']++;
            counts[secondString.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
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
