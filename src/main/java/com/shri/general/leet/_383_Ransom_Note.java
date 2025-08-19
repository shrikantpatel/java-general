package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/ransom-note/
 * <p>
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class _383_Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {

        // If either string is null, return false
        if (ransomNote == null || magazine == null) return false;

        // If ransomNote is longer than magazine, it's impossible to construct
        if (ransomNote.length() > magazine.length()) return false;

        // Array to store the frequency of each character in magazine
        int[] charCount = new int[26];

        // Populate the array with the character counts from magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // If a character is missing, return false
            }
            charCount[c - 'a']--; // Decrement the count for the character
        }

        return true; // All characters in ransomNote are accounted for
    }


    @Test
    void returnsFalseWhenRansomNoteHasExtraCharacters() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertFalse(solution.canConstruct("aa", "ab"));
    }

    @Test
    void returnsTrueWhenRansomNoteCanBeConstructed() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertTrue(solution.canConstruct("aa", "aab"));
    }

    @Test
    void returnsFalseWhenMagazineIsEmpty() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertFalse(solution.canConstruct("a", ""));
    }

    @Test
    void returnsTrueWhenRansomNoteIsEmpty() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertTrue(solution.canConstruct("", "abc"));
    }

    @Test
    void returnsFalseWhenRansomNoteHasCharactersNotInMagazine() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertFalse(solution.canConstruct("abc", "abd"));
    }

    @Test
    void returnsTrueWhenRansomNoteAndMagazineAreIdentical() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertTrue(solution.canConstruct("abc", "abc"));
    }

    @Test
    void returnsFalseWhenRansomNoteRequiresMoreOccurrencesThanMagazineHas() {
        _383_Ransom_Note solution = new _383_Ransom_Note();
        Assertions.assertFalse(solution.canConstruct("aaa", "aa"));
    }
}
