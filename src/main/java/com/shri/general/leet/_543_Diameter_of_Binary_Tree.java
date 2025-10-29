package com.shri.general.leet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class _543_Diameter_of_Binary_Tree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    @Test
    void testDiameterOfBinaryTree() {
        _543_Diameter_of_Binary_Tree solver = new _543_Diameter_of_Binary_Tree();

        // Tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        assertEquals(3, solver.diameterOfBinaryTree(root));

        // Tree: [1]
        TreeNode single = new TreeNode(1);
        assertEquals(0, solver.diameterOfBinaryTree(single));

        // Tree: null
        assertEquals(0, solver.diameterOfBinaryTree(null));
    }
}
