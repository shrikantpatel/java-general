package com.shri.demo.leet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
227. Basic Calculator 1


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
public class Basic_Calculator_1_Bhumi_Interview {

    public int calculate(String s) {

        // List of the operations
        List<String> operations = new ArrayList<>();

        // List of the operands
        List<Integer> numberList = new ArrayList<>();


        // Parse the string to separate the space, operands and operation
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                // if digit continue, appending to the number
                number.append(currentChar);
            } else if (currentChar == '+' || currentChar == '-') {
                // if we get to + or - that we done reading the digit, so save it to numberlist
                numberList.add(Integer.parseInt(number.toString()));
                number = new StringBuilder();
                operations.add(String.valueOf(currentChar));
            }
        }

        numberList.add(Integer.parseInt(number.toString()));

        Integer Operand1 = numberList.get(0);
        Integer Operand2 = null;

        for (int i = 0; i < operations.size(); i++) {

            Operand2 = numberList.get(i + 1);
            if ("+".equals(operations.get(i))) {
                Operand1 = Math.addExact(Operand1, Operand2);
            }
            if ("-".equals(operations.get(i))) {
                Operand1 = Math.subtractExact(Operand1, Operand2);
            }
        }

        return Operand1;
    }

    @Test
    public void testScenario1() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(6, test.calculate("2+2+2"));
    }

    @Test
    public void testScenario2() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(2, test.calculate("2+2-2"));
    }

    @Test
    public void testScenario3() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(2, test.calculate("2+ 2 -2"));
    }

    @Test
    public void testScenario4() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(-3, test.calculate("2+2+2-3-3-3"));
    }

    @Test
    public void testScenario5() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(0, test.calculate("2+2-2-2"));
    }

    @Test
    public void testScenario6() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(-1, test.calculate("2+ 2 -2 -3 -3 +   3"));
    }

    @Test
    public void testScenario7() {
        Basic_Calculator_1_Bhumi_Interview test = new Basic_Calculator_1_Bhumi_Interview();
        assertEquals(5, test.calculate("0 + 12 -   2  -2 -3 -3 +   3"));
    }
}
