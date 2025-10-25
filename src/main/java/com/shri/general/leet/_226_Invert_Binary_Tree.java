package com.shri.general.leet;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class _226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode node) {

        if (node == null) return null;
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }
}
