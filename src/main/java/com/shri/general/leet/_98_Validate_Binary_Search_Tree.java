package com.shri.general.leet;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class _98_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        // We start with null for both min and max because the root
        // of the entire tree has no upper or lower constraints.
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        // Base Case: An empty tree (or reaching past a leaf) is
        // technically a valid BST.
        if (root == null) return true;

        // Check Lower Bound:
        // If min is not null, we are in a right subtree where every
        // node must be greater than 'min'. If the current value is
        // less than or equal to 'min', it's invalid.
        if (min != null && root.val <= min) return false;

        // Check Upper Bound:
        // If max is not null, we are in a left subtree where every
        // node must be less than 'max'. If the current value is
        // greater than or equal to 'max', it's invalid.
        if (max != null && root.val >= max) return false;

        // Recursive Step:
        // 1. When going LEFT: The 'max' becomes the current node's value.
        // 2. When going RIGHT: The 'min' becomes the current node's value.
        // Both subtrees must return true for the whole tree to be valid.
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }


    // Basic TreeNode definition
    private static class TreeNode {
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
        void testValidBST_simple() {
            /*
                 2
                / \
               1   3
             */
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);

            _98_Validate_Binary_Search_Tree solver =
                    new _98_Validate_Binary_Search_Tree();

            boolean result = solver.isValidBST(root);

            org.junit.jupiter.api.Assertions.assertTrue(result);
        }

        @org.junit.jupiter.api.Test
        void testInvalidBST_leftViolation() {
            /*
                 5
                / \
               1   4
                  / \
                 3   6
             Invalid because 4 < 5 but is in right subtree
             */
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);
            root.right.left = new TreeNode(3);
            root.right.right = new TreeNode(6);

            _98_Validate_Binary_Search_Tree solver =
                    new _98_Validate_Binary_Search_Tree();

            boolean result = solver.isValidBST(root);

            org.junit.jupiter.api.Assertions.assertFalse(result);
        }

        @org.junit.jupiter.api.Test
        void testSingleNode() {
            TreeNode root = new TreeNode(10);

            _98_Validate_Binary_Search_Tree solver =
                    new _98_Validate_Binary_Search_Tree();

            boolean result = solver.isValidBST(root);

            org.junit.jupiter.api.Assertions.assertTrue(result);
        }

        @org.junit.jupiter.api.Test
        void testValidBST_deeper() {
            /*
                    8
                   / \
                  3   10
                 / \    \
                1   6    14
                   / \   /
                  4   7 13
             */
            TreeNode root = new TreeNode(8);
            root.left = new TreeNode(3);
            root.right = new TreeNode(10);

            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(6);

            root.left.right.left = new TreeNode(4);
            root.left.right.right = new TreeNode(7);

            root.right.right = new TreeNode(14);
            root.right.right.left = new TreeNode(13);

            _98_Validate_Binary_Search_Tree solver =
                    new _98_Validate_Binary_Search_Tree();

            boolean result = solver.isValidBST(root);

            org.junit.jupiter.api.Assertions.assertTrue(result);
        }

        @org.junit.jupiter.api.Test
        void testInvalidBST_duplicateValue() {
            /*
                 2
                / \
               1   2   <-- duplicates invalidate BST
             */
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(2);

            _98_Validate_Binary_Search_Tree solver =
                    new _98_Validate_Binary_Search_Tree();

            boolean result = solver.isValidBST(root);

            org.junit.jupiter.api.Assertions.assertFalse(result);
        }

        @org.junit.jupiter.api.Test
        void testInvalidBST_case_5_4_6_null_null_3_7() {
            /*
                 5
                / \
               4   6
                  / \
                 3   7

               This is NOT a valid BST because:
               - Node 3 is in the right subtree of 5 but 3 < 5
            */

            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(6);
            root.right.left = new TreeNode(3);
            root.right.right = new TreeNode(7);

            _98_Validate_Binary_Search_Tree solver =
                    new _98_Validate_Binary_Search_Tree();

            boolean result = solver.isValidBST(root);

            // Expected: false
            org.junit.jupiter.api.Assertions.assertFalse(result);
        }
    }
}