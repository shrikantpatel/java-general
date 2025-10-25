package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class _21_Merge_Two_Sorted_List {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

         // create new list to hold merged values
         ListNode merged = new ListNode(-1);
         ListNode current = merged;

         while (list1 != null && list2 != null) {

             if (list1.val <= list2.val) {
                 current.next = list1;
                 list1 = list1.next;
             } else {
                 current.next = list2;
                 list2 = list2.next;
             }
             current = current.next;
         }

        current.next = (list1 != null) ? list1 : list2;
        return merged.next;
    }

    // 🔍 Helper to create a linked list from array
    private ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // 🔍 Helper to compare two linked lists
    private void assertListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(expected);
        assertNull(actual);
    }

    // ✅ Unit Test
    @Test
    public void testMergeTwoLists() {
        _21_Merge_Two_Sorted_List merger = new _21_Merge_Two_Sorted_List();

        ListNode list1 = buildList(new int[]{1, 3, 5});
        ListNode list2 = buildList(new int[]{2, 4, 6});
        ListNode expected = buildList(new int[]{1, 2, 3, 4, 5, 6});

        ListNode result = merger.mergeTwoLists(list1, list2);
        assertListEquals(expected, result);
    }

}
