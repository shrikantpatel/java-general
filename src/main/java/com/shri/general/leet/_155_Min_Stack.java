package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class _155_Min_Stack {

    // Main stack stores all pushed values in normal LIFO order
    Deque<Integer> mainStack = new ArrayDeque<>();

    // Min stack stores the minimum value at each level of the main stack
    // The top of minStack always represents the current minimum
    Deque<Integer> minStack = new ArrayDeque<>();

    public _155_Min_Stack() {
    }

    // Push a value onto the stack
    public void push(int val) {

        // Always push the value onto the main stack
        mainStack.addLast(val);

        // For the min stack:
        // - If empty, this value is the minimum
        // - Otherwise, compare with the previous minimum and store the smaller one
        // This ensures minStack mirrors mainStack in size and tracks historical minimums
        if (minStack.isEmpty()) {
            minStack.addLast(val);
        } else {
            minStack.addLast(Math.min(val, minStack.getLast()));
        }
    }

    // Pop removes the top element from BOTH stacks
    // This keeps the min history aligned with the main stack
    public void pop() {
        mainStack.removeLast();
        minStack.removeLast();
    }

    // Return the top element of the main stack
    public int top() {
        return mainStack.getLast();
    }

    // Return the current minimum in O(1)
    // The top of minStack always holds the minimum for the current stack state
    public int getMin() {
        return minStack.getLast();
    }

    // -------------------------------------------------------
    // JUNIT TESTS (as requested, inside the same class)
    // -------------------------------------------------------

    @Test
    void testPushAndTop() {
        _155_Min_Stack stack = new _155_Min_Stack();
        stack.push(5);
        stack.push(3);
        stack.push(7);

        assertEquals(7, stack.top());
    }

    @Test
    void testGetMinSimple() {
        _155_Min_Stack stack = new _155_Min_Stack();
        stack.push(5);
        stack.push(3);
        stack.push(7);

        assertEquals(3, stack.getMin());
    }

    @Test
    void testGetMinAfterPop() {
        _155_Min_Stack stack = new _155_Min_Stack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.pop(); // removes 7

        assertEquals(3, stack.getMin());

        stack.pop(); // removes 3
        assertEquals(5, stack.getMin());
    }

    @Test
    void testPushPopSequence() {
        _155_Min_Stack stack = new _155_Min_Stack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);

        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
    }
}