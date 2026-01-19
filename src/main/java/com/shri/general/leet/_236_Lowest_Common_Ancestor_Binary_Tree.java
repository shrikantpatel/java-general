package com.shri.general.leet;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class _236_Lowest_Common_Ancestor_Binary_Tree {

    /**
     * Standard recursive LCA solution.
     *
     * Key idea:
     * - If the current node is null → no LCA here.
     * - If the current node is p or q → return it upward.
     * - Recursively search left and right subtrees.
     * - If both sides return non-null → this node is the LCA.
     * - Otherwise return whichever side is non-null.
     *
     * This works because the first node where p and q split into
     * different subtrees is the lowest common ancestor.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case 1: reached the end of a branch
        if (root == null) {
            return null;
        }

        // Base case 2: found p or q
        // Returning the node itself signals “I found one target here”
        if (root == p || root == q) {
            return root;
        }

        // Search left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /**
         * If both left and right returned non-null:
         * - It means p was found in one subtree
         * - And q was found in the other subtree
         * Therefore, THIS node is the first point where their paths meet.
         */
        if (left != null && right != null) {
            return root;
        }

        /**
         * If only one side is non-null:
         * - That side contains either p or q (or their LCA)
         * - Bubble that result upward
         */
        return left != null ? left : right;
    }

    // Simple TreeNode definition for testing
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @org.junit.jupiter.api.Nested
    class Tests {

        @org.junit.jupiter.api.Test
        void testLeetCodeSample1() {
            /*
             Tree:
                     3
                   /   \
                  5     1
                 / \   / \
                6   2 0   8
                   / \
                  7   4
             */

            TreeNode root = new TreeNode(3);

            root.left = new TreeNode(5);
            root.right = new TreeNode(1);

            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);

            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);

            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            TreeNode p = root.left;      // 5
            TreeNode q = root.right;     // 1

            _236_Lowest_Common_Ancestor_Binary_Tree solver =
                    new _236_Lowest_Common_Ancestor_Binary_Tree();

            TreeNode result = solver.lowestCommonAncestor(root, p, q);

            // Expected LCA = 3
            org.junit.jupiter.api.Assertions.assertSame(root, result);
        }

        @org.junit.jupiter.api.Test
        void testLeetCodeSample2() {
            /*
             Same tree as above
             LCA of 5 and 4 is 5
             */

            TreeNode root = new TreeNode(3);

            root.left = new TreeNode(5);
            root.right = new TreeNode(1);

            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);

            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);

            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            TreeNode p = root.left;                 // 5
            TreeNode q = root.left.right.right;     // 4

            _236_Lowest_Common_Ancestor_Binary_Tree solver =
                    new _236_Lowest_Common_Ancestor_Binary_Tree();

            TreeNode result = solver.lowestCommonAncestor(root, p, q);

            // Expected LCA = 5
            org.junit.jupiter.api.Assertions.assertSame(p, result);
        }

        @org.junit.jupiter.api.Test
        void testNodesOnSameSide() {
            /*
             Tree:
                 10
                /
               5
              /
             2
             */

            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.left.left = new TreeNode(2);

            TreeNode p = root.left;          // 5
            TreeNode q = root.left.left;     // 2

            _236_Lowest_Common_Ancestor_Binary_Tree solver =
                    new _236_Lowest_Common_Ancestor_Binary_Tree();

            TreeNode result = solver.lowestCommonAncestor(root, p, q);

            // Expected LCA = 5
            org.junit.jupiter.api.Assertions.assertSame(p, result);
        }

        @org.junit.jupiter.api.Test
        void testRootIsLCA() {
            TreeNode root = new TreeNode(7);
            root.left = new TreeNode(3);
            root.right = new TreeNode(11);

            TreeNode p = root.left;      // 3
            TreeNode q = root.right;     // 11

            _236_Lowest_Common_Ancestor_Binary_Tree solver =
                    new _236_Lowest_Common_Ancestor_Binary_Tree();

            TreeNode result = solver.lowestCommonAncestor(root, p, q);

            // Expected LCA = 7
            org.junit.jupiter.api.Assertions.assertSame(root, result);
        }
    }
}