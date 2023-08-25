package com.shri.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Most_Char_Count {

    public static char mostCharCount(String input) {

        char[] charArray = input.toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();

        int maxCount = 0;
        char maxChar = 0;

        for (int i = 0 ; i < charArray.length; i++) {
            char currentChar = charArray[i];
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

            if (maxCount < charCountMap.get(currentChar)) {
                maxCount = charCountMap.get(currentChar);
                maxChar = currentChar;
            } else if (maxCount == charCountMap.get(currentChar)) {

                // compare the position of character if the both character have same number of occurence.
                // if they same # of concurrence in that case take set maxChar to value that earliest in the string.
                // for "google" without this condition it will print 'o' instead of 'g'
                if (input.indexOf(currentChar) < input.indexOf(maxChar)){
                    maxChar = currentChar;
                }
            }
        }

        return maxChar;
    }


    @Test
    public void test1() {
        Most_Char_Count obj = new Most_Char_Count();
        System.out.print(obj.mostCharCount("google"));
        Assert.assertEquals('g', obj.mostCharCount("google"));
    }

    @Test
    public void test2() {
        Most_Char_Count obj = new Most_Char_Count();
        System.out.print(obj.mostCharCount("gooogle"));
        Assert.assertEquals('o', obj.mostCharCount("gooogle"));
    }

    @Test
    public void test3() {
        Most_Char_Count obj = new Most_Char_Count();
        System.out.print(obj.mostCharCount("shrikant"));
        Assert.assertEquals('s', obj.mostCharCount("shrikant"));
    }

}
