package com.shri.general.leet;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {

        Deque<Long> stack = new ArrayDeque<>();
        long current = 0;
        for (String s : tokens) {

            if (!isOperator(s)) {
                stack.push(Long.parseLong(s));
            } else {
                long num2 = stack.pop();
                long num1 = stack.pop();

                current = operation(num1, num2, s.charAt(0));
                stack.push(current);
            }
        }

        return stack.pop().intValue();
    }

    private boolean isOperator(String s) {
        return s.length() == 1 && "+-*/".indexOf(s.charAt(0)) != -1;
    }

    private long operation(long num1, long num2, char c) {

        return switch (c) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2; // truncates toward zero
            default -> throw new IllegalArgumentException("Invalid operator: " + c);
        };
    }

    @org.junit.jupiter.api.Nested
    class Tests {

        @org.junit.jupiter.api.Test
        void testSimpleAddition() {
            String[] tokens = {"2", "3", "+"};

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(5, result);
        }

        @org.junit.jupiter.api.Test
        void testSimpleMultiplication() {
            String[] tokens = {"4", "5", "*"};

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(20, result);
        }

        @org.junit.jupiter.api.Test
        void testMixedOperations() {
            // Expression: (2 + 1) * 3 = 9
            String[] tokens = {"2", "1", "+", "3", "*"};

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(9, result);
        }

        @org.junit.jupiter.api.Test
        void testDivisionTruncatesTowardZero() {
            // 7 / -3 = -2 (Java truncates toward zero)
            String[] tokens = {"7", "-3", "/"};

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(-2, result);
        }

        @org.junit.jupiter.api.Test
        void testLeetCodeExample() {
            // Example: ["4","13","5","/","+"] = 4 + (13/5) = 6
            String[] tokens = {"4", "13", "5", "/", "+"};

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(6, result);
        }

        @org.junit.jupiter.api.Test
        void testComplexExpression() {
            // ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
            // Expected: 22
            String[] tokens = {
                    "10","6","9","3","+","-11","*","/","*","17","+","5","+"
            };

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(22, result);
        }

        @org.junit.jupiter.api.Test
        void testSingleNumberInput() {
            String[] tokens = {"42"};

            _150_Reverse_Polish_Notation solver =
                    new _150_Reverse_Polish_Notation();

            int result = solver.evalRPN(tokens);

            org.junit.jupiter.api.Assertions.assertEquals(42, result);
        }

    }
}