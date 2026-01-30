package com.shri.general.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class _199_Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        queue.push(root);

        while (!queue.isEmpty()) {

            TreeNode[] list = queue.toArray(TreeNode[]::new);
            queue.clear();
            res.add(list[0].val);
            for (TreeNode node :list) {
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
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