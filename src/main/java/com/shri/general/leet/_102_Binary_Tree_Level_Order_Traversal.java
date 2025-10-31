package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class _102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> nodeAtLevel = new ArrayList<>();
            for (int i = 0; i < levelSize ; i++) {
                TreeNode node = queue.poll();
                nodeAtLevel.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            results.add(nodeAtLevel);
        }

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