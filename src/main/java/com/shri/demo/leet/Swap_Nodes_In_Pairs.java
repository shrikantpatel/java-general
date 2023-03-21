package com.shri.demo.leet;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
class Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {

        ListNode next = null;

        // if head is null there is nothing to do
        if (head != null ) {
            next = head.next;
        }

        if (next != null) {
            ListNode temp = next.next;

            head.next = swapPairs(temp);

            // swap next and head ie next -> current head and head = next
            next.next = head;
            head = next;
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}