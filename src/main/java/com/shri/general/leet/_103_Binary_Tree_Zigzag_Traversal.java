package com.shri.general.leet;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class _103_Binary_Tree_Zigzag_Traversal {

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        // return 2 dimensional list.
        // outer list contains all the element at level 0, 1, 2, 3 etc.
        // inner list is the on the element at that specific level
        traverseTree(root, 0, result);

        //we want zig-zag ie move left to right for level 0
        //move right to left for level 1
        //move left to right from level 2 and so on and so forth
        //below achives that
        int count = 0;
        for (List<Integer> list :result) {
            if (count % 2 == 1) Collections.reverse(list);
            count++;
        }
        return result;
    }

    public void traverseTree(TreeNode root, int level, List<List<Integer>> result) {

        List<Integer> list = null;

        // if reach the level above current result size we need to add the list to the master list
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        list = result.get(level);

        if (root == null) {
            return;
        } else {
            list.add(root.val);
        }

        if (root.left != null) {
            traverseTree(root.left,level+1, result);
        }
        if (root.right != null) {
            traverseTree(root.right,level+1, result);
        }
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {

        // Initialize the result list to hold values level by level
        List<List<Integer>> results = new ArrayList<>();

        // Edge case: if the tree is empty, return an empty list
        if (root == null) return results;

        // Use a queue to perform BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        boolean leftToRight = true;

        // Continue until all levels are processed
        while (!queue.isEmpty()) {
            // Determine the number of nodes at the current level
            int levelSize = queue.size();

            // List to hold node values for this level
            List<Integer> nodeAtLevel = new LinkedList<>();

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                // Remove the node from the front of the queue
                TreeNode node = queue.poll();

                // Add its value to the current level list
                if (leftToRight) {
                    nodeAtLevel.addLast(node.val);
                } else {
                    nodeAtLevel.addFirst(node.val);
                }

                // Add left and right children to the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add the current level's values to the final result
            results.add(nodeAtLevel);
            leftToRight = !leftToRight;
        }

        // Return the list of levels
        return results;

    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1));
        assertEquals(expected, zigzagLevelOrder1(root));
        assertEquals(expected, zigzagLevelOrder2(root));
    }

    @Test
    public void testEmptyTree() {
        TreeNode root = null;
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, zigzagLevelOrder1(root));
        assertEquals(expected, zigzagLevelOrder2(root));
    }

    @Test
    public void testTwoLevels() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2)
        );
        assertEquals(expected, zigzagLevelOrder1(root));
        assertEquals(expected, zigzagLevelOrder2(root));
    }

    @Test
    public void testThreeLevelsBalanced() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
        );
        assertEquals(expected, zigzagLevelOrder1(root));
        assertEquals(expected, zigzagLevelOrder2(root));
    }

    @Test
    public void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4), null), null), null);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );
        assertEquals(expected, zigzagLevelOrder1(root));
        assertEquals(expected, zigzagLevelOrder2(root));
    }

    @Test
    public void testRightSkewedTree() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4)))
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );
        assertEquals(expected, zigzagLevelOrder1(root));
        assertEquals(expected, zigzagLevelOrder2(root));
    }


}