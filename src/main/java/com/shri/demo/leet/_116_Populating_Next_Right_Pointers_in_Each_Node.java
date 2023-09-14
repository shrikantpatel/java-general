package com.shri.demo.leet;

import io.micrometer.shaded.org.pcollections.PCollection;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 116. Populating Next Right Pointers in Each Node
 * Medium
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

    public TreeNode connect(TreeNode root) {

        Queue<TreeNode> currentLevel = new LinkedBlockingQueue<>();
        Queue<TreeNode> nextLevel = new LinkedBlockingQueue<>();

        if (root == null) return null;
        currentLevel.add(root);

        TreeNode next = null;
        TreeNode previous = null;
        int counter = 0;
        int totalElement = currentLevel.size();

        while (counter < totalElement) {

            next = currentLevel.remove();
            if (next != null) {
                if (next.left != null) nextLevel.add(next.left);
                if (next.right != null) nextLevel.add(next.right);
            }

            // when its the 1st element there is no previous element
            if (previous != null) {
                previous.next = next;
            }
            previous = next;

            // when it last element set the next to null and reset the temp variable;
            if (counter == totalElement - 1) {
                next.next = null;

                // reset the temp variable.
                previous = null;
                next = null;
                counter = 0;
                currentLevel.addAll(nextLevel);
                totalElement = currentLevel.size();
                nextLevel = new LinkedBlockingQueue<>();
            } else {
                counter++;
            }

        }
        return root;
    }

    public TreeNode connect1(TreeNode root) {

        Queue<TreeNode> currentLevel = new LinkedBlockingQueue<>();

        if (root == null) return null;
        currentLevel.add(root);
        TreeNode previous = null;

        while (!currentLevel.isEmpty()) {

            int counter = currentLevel.size();
            previous = currentLevel.remove();

            for (int i = 0; i < counter; i++) {

                if (previous.left != null) currentLevel.add(previous.left);
                if (previous.right != null) currentLevel.add(previous.right);
                if (i != counter-1) {
                    previous.next = currentLevel.remove();
                    previous = previous.next;
                }
            }

        }
        return root;
    }

    @Test
    public void test1() {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        TreeNode rootNode = TreeNode.createTree(elements);
        //connect(rootNode);
        connect1(rootNode);
        int i = 0;
    }

}
