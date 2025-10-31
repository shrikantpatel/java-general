package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class _102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Initialize the result list to hold values level by level
        List<List<Integer>> results = new ArrayList<>();

        // Edge case: if the tree is empty, return an empty list
        if (root == null) return results;

        // Use a queue to perform BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        // Continue until all levels are processed
        while (!queue.isEmpty()) {
            // Determine the number of nodes at the current level
            int levelSize = queue.size();

            // List to hold node values for this level
            List<Integer> nodeAtLevel = new ArrayList<>();

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                // Remove the node from the front of the queue
                TreeNode node = queue.poll();

                // Add its value to the current level list
                nodeAtLevel.add(node.val);

                // Add left and right children to the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add the current level's values to the final result
            results.add(nodeAtLevel);
        }

        // Return the list of levels
        return results;

    }

    @Test
    public void testEmptyTree() {
        _102_Binary_Tree_Level_Order_Traversal solver = new _102_Binary_Tree_Level_Order_Traversal();
        assertEquals(Collections.emptyList(), solver.levelOrder(null));
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(42);
        _102_Binary_Tree_Level_Order_Traversal solver = new _102_Binary_Tree_Level_Order_Traversal();
        assertEquals(List.of(List.of(42)), solver.levelOrder(root));
    }

    @Test
    public void testTwoLevels() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        _102_Binary_Tree_Level_Order_Traversal solver = new _102_Binary_Tree_Level_Order_Traversal();
        assertEquals(List.of(List.of(1), List.of(2, 3)), solver.levelOrder(root));
    }

    @Test
    public void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        _102_Binary_Tree_Level_Order_Traversal solver = new _102_Binary_Tree_Level_Order_Traversal();
        assertEquals(List.of(List.of(1), List.of(2), List.of(3)), solver.levelOrder(root));
    }

    @Test
    public void testRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        _102_Binary_Tree_Level_Order_Traversal solver = new _102_Binary_Tree_Level_Order_Traversal();
        assertEquals(List.of(List.of(1), List.of(2), List.of(3)), solver.levelOrder(root));
    }

    @Test
    public void testBalancedTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        _102_Binary_Tree_Level_Order_Traversal solver = new _102_Binary_Tree_Level_Order_Traversal();
        assertEquals(
                List.of(
                        List.of(10),
                        List.of(5, 15),
                        List.of(3, 7, 12, 18)
                ),
                solver.levelOrder(root)
        );
    }
}