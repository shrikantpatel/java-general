package com.shri.demo.leet;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 160. Intersection of Two Linked Lists
 * Easy
 * <p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the function returns.
 * <p>
 * Custom Judge:
 * <p>
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * <p>
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
 * <p>
 * Example 2:
 * <p>
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * Example 3:
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 */

public class _160_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode l1 = headA;
        ListNode l2 = headB;

        /**
         *******************************************************************************************
         * Intersecting element with different size
         *
         * l1 -> 13 element -> 10 unique and intersect l2 at 11, 10 element unique + 3 shared with l2
         * l2 -> 8 element -> 5 unique and intersect l1 at 6, 5 element unique + 3 shared with l1
         *
         * <-----     10  -------> [Intersection] <--3---> <change in pointer to l2> <----  5 ---> [Intersection]
         * <----  5 ---> [Intersection] <--3---> <change in pointer to l1> <-----     10  -------> [Intersection]
         * a=b=intersecting element  end while loop
         *
         *******************************************************************************************
         * Intersecting element with same size
         *
         * l1 -> 8 element -> 5 unique and intersect l2 at 6, 5 element unique + 3 shared with l2
         * l2 -> 8 element -> 5 unique and intersect l1 at 6, 5 element unique + 3 shared with l1
         *
         * <----  5 ---> [Intersection]
         * <----  5 ---> [Intersection]
         * a=b=5 = intersecting element end while loop
         *
         *******************************************************************************************
         * Non Intersecting element with different size
         *
         * l1 -> 13 element -> all 13 unique elements
         * l1 -> 8 element -> all 13 unique elements
         *
         * <-----     13  -------> <change in pointer to l2> <----  8 --->
         * <----  8 ---> <change in pointer to l1> <-----     13  ------->
         * a = b = null so ends with no match
         *
         *******************************************************************************************
         * Non Intersecting element with same size
         *
         * l1 -> 8 element -> all 8 unique elements
         * l1 -> 8 element -> all 8 unique elements
         *
         * <----  8 --->
         * <----  8 --->
         * a = b = null so ends with no match
         */
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }

        return l1;
    }

}
