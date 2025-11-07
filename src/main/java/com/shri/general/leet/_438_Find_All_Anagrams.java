package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class _438_Find_All_Anagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] charsInP = new int[26];
        int[] charsInWindow = new int[26];

        if (s.length() < p.length()) return result;

        for (char c : p.toCharArray()) {
            charsInP[c-'a']++;
        }

        for (int i = 0 ; i < s.length() ; i++) {

            charsInWindow[s.charAt(i) - 'a' ]++;

            if (i >= p.length()) {
              charsInWindow[s.charAt(i-p.length()) - 'a']--;
            }

            if (Arrays.equals(charsInP, charsInWindow)) result.add(i-p.length()+1);

        }

        return result;
    }


    // JUnit 5 test cases
    public static class FindAllAnagramsTest {

        private final _438_Find_All_Anagrams solver = new _438_Find_All_Anagrams();

        @Test
        public void testExample1() {
            String s = "cbaebabacd";
            String p = "abc";
            List<Integer> expected = Arrays.asList(0, 6);
            List<Integer> actual = solver.findAnagrams(s, p);
            assertEquals(expected, actual);
        }

        @Test
        public void testExample2() {
            String s = "abab";
            String p = "ab";
            List<Integer> expected = Arrays.asList(0, 1, 2);
            List<Integer> actual = solver.findAnagrams(s, p);
            assertEquals(expected, actual);
        }

        @Test
        public void testEmptyString() {
            String s = "";
            String p = "a";
            List<Integer> expected = List.of();
            List<Integer> actual = solver.findAnagrams(s, p);
            assertEquals(expected, actual);
        }
    }
}

