package com.shri.demo.leet;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * 2. Add Two Numbers
 * Medium
 * 27.9K
 * 5.4K
 * Companies
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

public class _2_Add_Two_Num {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans = null;

        int num1 = 0;
        int num2 = 0;
        int carryOver = 0;
        int count = 0;
        ListNode currentNode = null;
        ListNode previousNode = null;

        while (l1 != null || l2 != null) {

            currentNode = new ListNode();
            if (previousNode != null) {
                previousNode.next = currentNode;
            } else {
                ans = currentNode;
            }

            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carryOver;

            if (sum > 9) {
                carryOver = 1;
                currentNode.val = sum % 10;
            } else {
                carryOver = 0;
                currentNode.val = sum;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            previousNode = currentNode;
        }

        if (carryOver > 0 ) {
            currentNode = new ListNode();
            currentNode.val = carryOver;
            previousNode.next = currentNode;
        }

        return ans;

    }
}
