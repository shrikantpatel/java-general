package com.shri.demo.leet;


/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * <p>
 * 328. Odd Even Linked List
 * Medium
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * <p>
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class _328_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ListNode currentEven = null;
        ListNode currentOdd = null;
        ListNode headEven = null;

        ListNode current = head;
        int count = 1;
        while (current != null) {

            if (count % 2 == 0) {
                if (currentEven == null) {
                    currentEven = current;
                    headEven = current;
                }
                else {
                    currentEven.next = current;
                    currentEven = currentEven.next;
                }
            } else {
                if (currentOdd == null) {
                    currentOdd = current;
                }
                else {
                    currentOdd.next = current;
                    currentOdd = currentOdd.next;
                }
            }

            current = current.next;
            count++;
        }
        currentOdd.next = headEven;
        if (currentEven != null) currentEven.next = null;
        return head;
    }
    @Test
    public void test1() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode root = oddEvenList(node1);

    }
}
