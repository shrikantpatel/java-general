package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/add-binary/description/
 */
public class _67_Add_Binary {

    public String addBinary_1(String a, String b) {

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int maxLen = a.length() >= b.length() ? a.length() : b.length();

        StringBuilder result = new StringBuilder();
        char carry = '0';

        for (int i =0; i < maxLen; i++) {
            char a1 = i < a.length() ? a.charAt(i) : '0';
            char b1 = i < b.length() ? b.charAt(i) : '0';
            if (a1 == '0' && b1 == '0' && carry == '0') {
                result.append('0');
                carry = '0';
            } else if (a1 == '0' && b1 == '0' && carry == '1') {
                result.append('1');
                carry = '0';
            } else if (a1 == '0' && b1 == '1' && carry == '0') {
                result.append('1');
                carry = '0';
            } else if (a1 == '0' && b1 == '1' && carry == '1') {
                result.append('0');
                carry = '1';
            } else if (a1 == '1' && b1 == '0' && carry == '0') {
                result.append('1');
                carry = '0';
            } else if (a1 == '1' && b1 == '0' && carry == '1') {
                result.append('0');
                carry = '1';
            } else if (a1 == '1' && b1 == '1' && carry == '0') {
                result.append('0');
                carry = '1';
            } else if (a1 == '1' && b1 == '1' && carry == '1') {
                result.append('1');
                carry = '1';
            }
            System.out.println("result " + result);
        }

        if (carry == '1') result.append(1);
        return result.reverse().toString();
    }

    public String addBinary_2(String a, String b) {

        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    @Test
    public void testAddBinary_1() {
        assertEquals("100", addBinary_1("11", "1"));
        assertEquals("10101", addBinary_1("1010", "1011"));
        assertEquals("11110", addBinary_1("1111", "1111"));
        assertEquals("0", addBinary_1("0", "0"));
    }

    @Test
    public void testAddBinary_2() {
        assertEquals("100", addBinary_2("11", "1"));
        assertEquals("10101", addBinary_2("1010", "1011"));
        assertEquals("11110", addBinary_2("1111", "1111"));
        assertEquals("0", addBinary_2("0", "0"));
    }

}
