package com.shri.general.leet;


/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
*/

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }
}

public class Remove_Nth_Element_From_LinkList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        int count = 1;
        ListNode nodeToBeRemoved = head;
        ListNode nodeBeforeToBeRemoved = head;

        if (node == null) return null;

        do {
            if (count - n > 0) {
                nodeBeforeToBeRemoved = nodeToBeRemoved;
                nodeToBeRemoved = nodeToBeRemoved.next;
            }
            node = node.next;
            count ++;
        } while (node != null);

        if (nodeToBeRemoved == head)
        {
            return nodeToBeRemoved.next;
        } else {
            nodeBeforeToBeRemoved.next = nodeToBeRemoved.next;
            return head;
        }

    }

    public void printList(final ListNode start) {
        ListNode node = start;
        if (node == null) return;

        do {
            System.out.print(node.val + " ");
            node = node.next;
        }
        while (node != null);

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Remove_Nth_Element_From_LinkList sol = new Remove_Nth_Element_From_LinkList();
        sol.printList(node1);
        ListNode head = node1;
        head = sol.removeNthFromEnd(head, 5);
        System.out.println();
        sol.printList(head);

    }
}