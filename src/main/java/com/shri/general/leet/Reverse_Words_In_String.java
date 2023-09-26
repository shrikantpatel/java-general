package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Example 4:

Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"
Example 5:

Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow up:

Could you solve it in-place with O(1) extra space?
 */
public class Reverse_Words_In_String {

    public String reverseWords_Solution1(String s) {

        int i = s.length() - 1;
        char c;
        StringBuffer original = new StringBuffer(s);
        StringBuffer reverse = new StringBuffer();
        int endIndex = -1;
        int startIndex = 0;

        // iterate through the string from right end to left end (ie from end to start ie opposite direction)
        while (i >= 0) {
            c = s.charAt(i);
            if (c != ' ') {
                if (endIndex == -1) endIndex = i;
                startIndex = i;
            }

            //if this is space or last character in the sequence we done with word. copy it reserve order
            //and reset the variables
            if ((c == ' ' || i == 0 ) && endIndex != -1){
                reverse.append(original.subSequence(startIndex, endIndex + 1));
                reverse.append(' ');
                endIndex = -1;
                startIndex = 0;
            }
            i--;
        }

        //remove the trailing space
        int lastIndex = reverse.length() - 1;
        if (reverse.charAt(lastIndex) == ' ') {
            reverse.deleteCharAt(lastIndex);
        }

        System.out.println("-" + reverse.toString() + "-");
        return reverse.toString();
    }

    public String reverseWords_Solution2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    @Test
    public void testScenario1() {
        Reverse_Words_In_String sol = new Reverse_Words_In_String();
        Assert.assertEquals("blue is sky the", sol.reverseWords_Solution1("the sky is blue"));
        Assert.assertEquals("blue is sky the", sol.reverseWords_Solution2("the sky is blue"));
    }

    @Test
    public void testScenario2() {
        Reverse_Words_In_String sol = new Reverse_Words_In_String();
        Assert.assertEquals("world hello", sol.reverseWords_Solution1("  hello world  "));
        Assert.assertEquals("world hello", sol.reverseWords_Solution2("  hello world  "));
    }

    @Test
    public void testScenario3() {
        Reverse_Words_In_String sol = new Reverse_Words_In_String();
        Assert.assertEquals("example good a", sol.reverseWords_Solution1("a good   example"));
        Assert.assertEquals("example good a", sol.reverseWords_Solution2("a good   example"));
    }

    @Test
    public void testScenario4() {
        Reverse_Words_In_String sol = new Reverse_Words_In_String();
        Assert.assertEquals("S D N E I R F", sol.reverseWords_Solution1("F R  I   E    N     D      S      "));
        Assert.assertEquals("S D N E I R F", sol.reverseWords_Solution2("F R  I   E    N     D      S      "));
    }
}
