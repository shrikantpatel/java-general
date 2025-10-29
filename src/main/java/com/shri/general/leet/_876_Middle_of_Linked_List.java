package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class _876_Middle_of_Linked_List {

    public ListNode middleNode(ListNode head) {

        // Initialize two pointers: one moves 1 step at a time (slow), the other 2 steps at a time (fast)
        ListNode pointer_1x = head, pointer_2x = head;

        // Edge case: if the list is empty or has only one node, return it as the middle
        if (pointer_1x == null || pointer_1x.next == null) return pointer_1x;

        // Traverse the list:
        // - pointer_2x moves twice as fast as pointer_1x
        // - when pointer_2x reaches the end, pointer_1x will be at the middle
        while (pointer_1x != null && pointer_2x != null && pointer_2x.next != null) {
            pointer_1x = pointer_1x.next;
            pointer_2x = pointer_2x.next.next;
        }

        // Return the middle node
        return pointer_1x;

    }

    private ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0), curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    @Test
    void testMiddleNodeOdd() {
        _876_Middle_of_Linked_List solver = new _876_Middle_of_Linked_List();
        ListNode head = buildList(1, 2, 3, 4, 5);
        ListNode mid = solver.middleNode(head);
        assertEquals(3, mid.val);
    }

    @Test
    void testMiddleNodeEven() {
        _876_Middle_of_Linked_List solver = new _876_Middle_of_Linked_List();
        ListNode head = buildList(1, 2, 3, 4, 5, 6);
        ListNode mid = solver.middleNode(head);
        assertEquals(4, mid.val);
    }

    @Test
    void testMiddleNodeSingle() {
        _876_Middle_of_Linked_List solver = new _876_Middle_of_Linked_List();
        ListNode head = buildList(42);
        ListNode mid = solver.middleNode(head);
        assertEquals(42, mid.val);
    }

    @Test
    void testMiddleNodeNull() {
        _876_Middle_of_Linked_List solver = new _876_Middle_of_Linked_List();
        assertNull(solver.middleNode(null));
    }
}
