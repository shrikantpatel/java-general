package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Longest_NonRepeating_Sub_String_Length {
    public static long solution(String str) {

        int length = str.length();
        long longestSubString = 0;
        char c;

        for(int i = 0; i < length; i++)
        {
            Set<Character> visited = new HashSet<Character>();
            int currentLongestSubString = 0;

            for(int j = i; j < length; j++)
            {

                c = str.charAt(j);
                if (visited.contains(c))
                    break;
                else
                {
                    visited.add(c);
                    currentLongestSubString++;
                }
            }
            longestSubString = Math.max(longestSubString, currentLongestSubString);
        }

        return longestSubString;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, Longest_NonRepeating_Sub_String_Length.solution("nndNfdfdf"));
    }
}
