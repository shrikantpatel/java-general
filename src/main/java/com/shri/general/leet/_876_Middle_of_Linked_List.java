package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class _876_Middle_of_Linked_List {

    public ListNode middleNode(ListNode head) {
        return null;
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
