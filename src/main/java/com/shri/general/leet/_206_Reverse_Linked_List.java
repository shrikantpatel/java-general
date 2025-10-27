package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class _206_Reverse_Linked_List {

    public ListNode reverseList_1(ListNode head) {

        if (head == null) return null;

        ListNode newHead, temp = null;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        newHead = stack.pop();
        temp = newHead;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;

        return newHead;
    }

    public ListNode reverseList_2(ListNode head) {

        // If the list is empty, return null
        if (head == null) return null;

        // Initialize pointers:
        // 'previous' will trail behind 'current' and eventually become the new head
        ListNode previous = head;
        ListNode current = head.next;

        // Traverse the list and reverse the links
        while (current != null) {
            ListNode temp = current.next;   // Store the next node
            current.next = previous;        // Reverse the current node's pointer
            previous = current;             // Move 'previous' forward
            current = temp;                 // Move 'current' forward
        }

        // Original head becomes the tail; its next should be null
        head.next = null;

        // 'previous' now points to the new head of the reversed list
        return previous;
    }

    public ListNode reverseList_3(ListNode head) {
        // 'prev' will eventually point to the new head of the reversed list
        ListNode prev = null;

        // Traverse the list until all nodes are reversed
        while (head != null) {
            // Temporarily store the next node
            ListNode next = head.next;

            // Reverse the current node's pointer
            head.next = prev;

            // Move 'prev' and 'head' one step forward
            prev = head;
            head = next;
        }

        // 'prev' now points to the new head of the reversed list
        return prev;
    }

    // 🛠️ Helper to build linked list from array
    private ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // 🛠️ Helper to convert linked list to array
    private int[] toArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testReverseMultipleNodes() {
        ListNode input = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = reverseList_1(input);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(reversed));

        input = buildList(new int[]{1, 2, 3, 4, 5});
        reversed = reverseList_2(input);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(reversed));

        input = buildList(new int[]{1, 2, 3, 4, 5});
        reversed = reverseList_3(input);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(reversed));
    }

    @Test
    public void testReverseSingleNode() {
        ListNode input = buildList(new int[]{42});
        ListNode reversed = reverseList_1(input);
        assertArrayEquals(new int[]{42}, toArray(reversed));

        input = buildList(new int[]{42});
        reversed = reverseList_2(input);
        assertArrayEquals(new int[]{42}, toArray(reversed));

        input = buildList(new int[]{42});
        reversed = reverseList_3(input);
        assertArrayEquals(new int[]{42}, toArray(reversed));
    }

    @Test
    public void testReverseEmptyList() {
        ListNode reversed = reverseList_1(null);
        assertNull(reversed);

        reversed = reverseList_2(null);
        assertNull(reversed);

        reversed = reverseList_3(null);
        assertNull(reversed);
    }

}
