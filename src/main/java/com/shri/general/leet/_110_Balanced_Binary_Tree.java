package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class _110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {

        return findHeight(root) != -1;

    }

    private int findHeight(TreeNode node) {

        if (node == null) return 0;


        int rightHeight = findHeight(node.right);
        if (rightHeight == -1) return -1;

        int leftHeight = findHeight(node.left);
        if (leftHeight == -1) return -1;

        if (Math.abs(rightHeight - leftHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Test
    public void testBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        assertTrue(isBalanced(root));
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        assertFalse(isBalanced(root));
    }

    @Test
    public void testEmptyTree() {
        assertTrue(isBalanced(null));
    }

    @Test
    public void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertTrue(isBalanced(root));
    }

    @Test
    public void testUnbalancedSpecificTree() {
        // Construct the tree: [1,2,2,3,null,null,3,4,null,null,4]
        TreeNode leftLeaf4 = new TreeNode(4);
        TreeNode left3 = new TreeNode(3, leftLeaf4, null);
        TreeNode left2 = new TreeNode(2, left3, null);

        TreeNode rightLeaf4 = new TreeNode(4);
        TreeNode right3 = new TreeNode(3, null, rightLeaf4);
        TreeNode right2 = new TreeNode(2, null, right3);

        TreeNode root = new TreeNode(1, left2, right2);

        assertFalse(isBalanced(root));
    }

}
