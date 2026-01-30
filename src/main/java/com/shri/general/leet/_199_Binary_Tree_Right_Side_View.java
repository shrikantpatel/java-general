package com.shri.general.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class _199_Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // The first node we encounter in this loop is the rightmost one
                if (i == 0) res.add(node.val);

                // Add right child first so it's at the front for the next level
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        return res;

    }

    // ------------------------------------------------------------
    // TreeNode class (needed for tests)
    // ------------------------------------------------------------
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // ------------------------------------------------------------
    // JUnit 5 tests (no solution logic included)
    // ------------------------------------------------------------
    @org.junit.jupiter.api.Nested
    class Tests {

        @org.junit.jupiter.api.Test
        void testEmptyTree() {
            _199_Binary_Tree_Right_Side_View solver =
                    new _199_Binary_Tree_Right_Side_View();

            List<Integer> result = solver.rightSideView(null);

            org.junit.jupiter.api.Assertions.assertTrue(
                    result == null || result.isEmpty()
            );
        }

        @org.junit.jupiter.api.Test
        void testSingleNode() {
            _199_Binary_Tree_Right_Side_View solver =
                    new _199_Binary_Tree_Right_Side_View();

            TreeNode root = new TreeNode(1);

            List<Integer> result = solver.rightSideView(root);

            org.junit.jupiter.api.Assertions.assertEquals(
                    List.of(1),
                    result
            );
        }

        @org.junit.jupiter.api.Test
        void testRightLeaningTree() {
            _199_Binary_Tree_Right_Side_View solver =
                    new _199_Binary_Tree_Right_Side_View();

            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.right = new TreeNode(3);

            List<Integer> result = solver.rightSideView(root);

            org.junit.jupiter.api.Assertions.assertEquals(
                    List.of(1, 2, 3),
                    result
            );
        }

        @org.junit.jupiter.api.Test
        void testLeftLeaningTree() {
            _199_Binary_Tree_Right_Side_View solver =
                    new _199_Binary_Tree_Right_Side_View();

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(3);

            List<Integer> result = solver.rightSideView(root);

            // For a left-leaning tree, right-side view still sees only the topmost node at each level
            org.junit.jupiter.api.Assertions.assertEquals(
                    List.of(1, 2, 3),
                    result
            );
        }

        @org.junit.jupiter.api.Test
        void testMixedTree() {
            _199_Binary_Tree_Right_Side_View solver =
                    new _199_Binary_Tree_Right_Side_View();

            /*
                 1
                / \
               2   3
                \   \
                 5   4
             */

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(4);

            List<Integer> result = solver.rightSideView(root);

            org.junit.jupiter.api.Assertions.assertEquals(
                    List.of(1, 3, 4),
                    result
            );
        }
    }
}