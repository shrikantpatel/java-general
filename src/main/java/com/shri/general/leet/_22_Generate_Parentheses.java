package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * <p>
 * 22. Generate Parentheses
 * Medium
 * 19.8K
 * 809
 * Companies
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 */
public class _22_Generate_Parentheses {

    public List<String> generateParenthesis(int maxPairs) {

        List<String> list = new ArrayList<>();
        int startParenthesis = 0;
        int endParenthesis = 0;
        recursivelyGenerateParenthesis(startParenthesis, endParenthesis, maxPairs, "", list);
        return list;

    }

    void recursivelyGenerateParenthesis(int startParenthesis, int endParenthesis, int maxPairs, String ans, List<String> list) {

        if (startParenthesis < maxPairs)
            recursivelyGenerateParenthesis(startParenthesis+1, endParenthesis, maxPairs, ans + "(", list);

        if (endParenthesis < startParenthesis)
            recursivelyGenerateParenthesis(startParenthesis, endParenthesis+1, maxPairs, ans + ")", list);

        if (startParenthesis == endParenthesis && endParenthesis == maxPairs) {
            list.add(ans);
        }
    }

    @Test
    public void test1() {
        _22_Generate_Parentheses test = new _22_Generate_Parentheses();
        List expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(expected, test.generateParenthesis(3));
    }

    @Test
    public void test2() {
        _22_Generate_Parentheses test = new _22_Generate_Parentheses();
        List expected = Arrays.asList("(())", "()()");
        assertEquals(expected, test.generateParenthesis(2));
    }

    @Test
    public void test3() {
        _22_Generate_Parentheses test = new _22_Generate_Parentheses();
        List expected = Arrays.asList("()");
        assertEquals(expected, test.generateParenthesis(1));
    }

}
