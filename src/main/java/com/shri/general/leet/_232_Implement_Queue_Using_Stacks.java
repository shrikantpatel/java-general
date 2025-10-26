package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class _232_Implement_Queue_Using_Stacks {

    Stack<Integer> inStack = null;
    Stack<Integer> outStack = null;

    public _232_Implement_Queue_Using_Stacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        transferInToOut();
        return outStack.pop();
    }

    public int peek() {
        transferInToOut();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void transferInToOut()
    {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    @Test
    public void testQueueOperations() {
        _232_Implement_Queue_Using_Stacks queue = new _232_Implement_Queue_Using_Stacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertFalse(queue.empty());

        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    public void testEmptyQueue() {
        _232_Implement_Queue_Using_Stacks queue = new _232_Implement_Queue_Using_Stacks();
        assertTrue(queue.empty());
    }

    @Test
    public void testPushPopInterleaved() {
        _232_Implement_Queue_Using_Stacks queue = new _232_Implement_Queue_Using_Stacks();
        queue.push(10);
        assertEquals(10, queue.pop());

        queue.push(20);
        queue.push(30);
        assertEquals(20, queue.peek());
        assertEquals(20, queue.pop());
        assertEquals(30, queue.pop());
        assertTrue(queue.empty());
    }

}
