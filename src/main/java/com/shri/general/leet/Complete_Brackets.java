package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.lang.StringBuilder;

public class Complete_Brackets {

    public static String solution(String angles) {

        if (angles.trim().length() == 0) return angles;

        StringBuilder result = new StringBuilder(angles);
        int unMatchedClosingAngles = 0;
        int unMatchedOpeningAngles = 0;
        Stack<Character> charStack = new Stack<Character>();

        for (Character c : angles.toCharArray()) {
            if (c == '<') charStack.push(c);
            if (c == '>') {
                if (!charStack.empty() && charStack.peek() == '<') {
                    charStack.pop();
                } else {
                    charStack.push(c);
                }
            }
        }

        while (!charStack.empty()) {
            char c = charStack.pop();
            if (c == '<') unMatchedOpeningAngles++;
            if (c == '>') unMatchedClosingAngles++;

        }

        for (int i = 0; i < unMatchedOpeningAngles; i++) {
            result.append('>');
        }
        result.reverse();
        for (int i = 0; i < unMatchedClosingAngles; i++) {
            result.append("<");
        }

        return result.reverse().toString();
    }

    @Test
    public void test1() {
        assertEquals("<>", Complete_Brackets.solution("<"));
    }

    @Test
    public void test2() {
        assertEquals("", Complete_Brackets.solution(""));
    }

    @Test
    public void test3() {
        assertEquals("<<>>", Complete_Brackets.solution(">>"));
    }

    @Test
    public void test4() {
        assertEquals("<<<><>>>", Complete_Brackets.solution("<<<><>"));
    }

    @Test
    public void test5() {
        assertEquals("<><<><><<>>>", Complete_Brackets.solution("><<><><<"));
    }
}