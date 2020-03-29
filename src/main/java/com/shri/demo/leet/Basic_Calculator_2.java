package com.shri.demo.leet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/*
227. Basic Calculator 2


        Implement a basic calculator to evaluate a simple expression string.

        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

        Example 1:
        Input: "3+2*2"
        Output: 7

        Example 2:
        Input: " 3/2 "
        Output: 1

        Example 3:
        Input: " 3+5 / 2 "
        Output: 5
 */
@RunWith(MockitoJUnitRunner.class)
public class Basic_Calculator_2 {

    public int calculate(String s) {

        int length = s.length();

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char currentChar;
        char sign = '+';

        for (int i = 0; i < length; i++) {

            currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if ((!Character.isDigit(currentChar) && !Character.isSpaceChar(currentChar)) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                }
                sign = currentChar;
                num = 0;
            }
        }

        //the stack only has addition and subtraction
        int cal = 0;
        while (!stack.empty()) {
            cal = cal + stack.pop();
        }

        return cal;
    }

    @Test
    public void testScenario1() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(6, test.calculate("2+2+2"));
    }

    @Test
    public void testScenario2() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(2, test.calculate("2+2-2"));
    }

    @Test
    public void testScenario3() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(2, test.calculate("2+ 2 -2"));
    }

    @Test
    public void testScenario4() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(-3, test.calculate("2+2+2-3-3-3"));
    }

    @Test
    public void testScenario5() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(0, test.calculate("2+2-2-2"));
    }

    @Test
    public void testScenario6() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(-1, test.calculate("2+ 2 -2 -3 -3 +   3"));
    }

    @Test
    public void testScenario7() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(5, test.calculate("0 + 12 -   2  -2 -3 -3 +   3"));
    }

    @Test
    public void testScenario8() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(7, test.calculate("3+2*2"));
    }

    @Test
    public void testScenario9() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(1, test.calculate(" 3/2 "));
    }

    @Test
    public void testScenario10() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(5, test.calculate(" 3+5 / 2 "));
    }

    @Test
    public void testScenario11() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(10, test.calculate("2*3+4"));
    }
    @Test
    public void testScenario12() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(150, test.calculate("12*12+6"));
    }

    @Test
    public void testScenario13() {
        Basic_Calculator_2 test = new Basic_Calculator_2();
        assertEquals(-144, test.calculate("-12*12"));
    }
}
