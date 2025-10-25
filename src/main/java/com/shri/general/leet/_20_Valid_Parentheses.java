/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class _20_Valid_Parentheses {

    public boolean isValid(String s) {
        if (s == null) return false;
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')', '}', ']':
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
                default:
                    // Ignore other characters
                    break;
            }
        }
        return stack.isEmpty();
    }

    @org.junit.jupiter.api.Test
    void validInputs() {
        _20_Valid_Parentheses sol = new _20_Valid_Parentheses();
        assertTrue(sol.isValid("()"));
        assertTrue(sol.isValid("()[]{}"));
        assertTrue(sol.isValid("{[]}"));
        assertTrue(sol.isValid(""));
    }

    @org.junit.jupiter.api.Test
    void invalidInputs() {
        _20_Valid_Parentheses sol = new _20_Valid_Parentheses();
        assertFalse(sol.isValid("(]"));
        assertFalse(sol.isValid("([)]"));
        assertFalse(sol.isValid("]("));
    }

    @org.junit.jupiter.api.Test
    void nullInput() {
        _20_Valid_Parentheses sol = new _20_Valid_Parentheses();
        assertFalse(sol.isValid(null));
    }

    @Test
    void ignoresOtherCharacters() {
        _20_Valid_Parentheses sol = new _20_Valid_Parentheses();
        assertTrue(sol.isValid("(a)"));
        assertTrue(sol.isValid("[1{2}3]"));
        assertFalse(sol.isValid("(]x"));
    }
}
