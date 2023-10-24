package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 9. Palindrome Number
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class _9_Palindrome {

    public boolean isPalindrome1(int x) {
        boolean isPalindome = true;
        char[] orginal = String.valueOf(x).toCharArray();
        int length = orginal.length;
        for (int left = 0, right = length - 1; left < length / 2 && isPalindome == true; left++, right--) {
            if (orginal[left] != orginal[right]) {
                isPalindome = false;
            }
        }
        return isPalindome;
    }

    public boolean isPalindrome2(int x) {
        String original = String.valueOf(x);
        StringBuilder temp = new StringBuilder(original);
        String reverse = temp.reverse().toString();
        if (original.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test1() {
        _9_Palindrome palindrome = new _9_Palindrome();
        assertEquals(Boolean.TRUE, palindrome.isPalindrome1(121));
        assertEquals(Boolean.TRUE, palindrome.isPalindrome2(121));
    }

    @Test
    public void test2() {
        _9_Palindrome palindrome = new _9_Palindrome();
        assertEquals(Boolean.FALSE, palindrome.isPalindrome1(-121));
        assertEquals(Boolean.FALSE, palindrome.isPalindrome2(-121));
    }

    @Test
    public void test3() {
        _9_Palindrome palindrome = new _9_Palindrome();
        assertEquals(Boolean.FALSE, palindrome.isPalindrome1(10));
        assertEquals(Boolean.FALSE, palindrome.isPalindrome2(10));
    }
}
