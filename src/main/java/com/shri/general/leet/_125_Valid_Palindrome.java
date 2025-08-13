package com.shri.general.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _125_Valid_Palindrome {

    public boolean isPalindrome(String s) {

        // Remove all non-alphanumeric characters and convert the string to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize two pointers: one at the start and one at the end of the string
        int right = s.length() - 1, left = 0;

        // Loop until the pointers meet in the middle
        while (left < right) {

            // If characters at the current pointers don't match, it's not a palindrome
            if (s.charAt(right) != s.charAt(left)) return false;

            // Move the pointers closer to the center
            right--;
            left++;
        }

        // If all characters matched, the string is a palindrome
        return true;

    }

    private _125_Valid_Palindrome palindromeChecker;

    @BeforeEach
    void setUp() {
        palindromeChecker = new _125_Valid_Palindrome();
    }

    @Test
    void returnsTrueForSimplePalindrome() {
        Assertions.assertTrue(palindromeChecker.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void returnsTrueForEmptyString() {
        Assertions.assertTrue(palindromeChecker.isPalindrome(""));
    }

    @Test
    void returnsTrueForSingleCharacter() {
        Assertions.assertTrue(palindromeChecker.isPalindrome("x"));
    }

    @Test
    void returnsFalseForNonPalindrome() {
        Assertions.assertFalse(palindromeChecker.isPalindrome("hello"));
    }

    @Test
    void ignoresNonAlphanumericCharacters() {
        Assertions.assertTrue(palindromeChecker.isPalindrome(".,;:!"));
    }

    @Test
    void returnsTrueForPalindromeWithMixedCaseAndSymbols() {
        Assertions.assertTrue(palindromeChecker.isPalindrome("No 'x' in Nixon"));
    }

    @Test
    void returnsFalseForPalindromeWithDifferentAlphanumericContent() {
        Assertions.assertFalse(palindromeChecker.isPalindrome("race a car"));
    }

}

