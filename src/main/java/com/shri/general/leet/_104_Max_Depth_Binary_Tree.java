package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_Max_Depth_Binary_Tree {

    public int maxDepth(TreeNode node) {
        // Base case: if the node is null, the depth is 0
        if (node == null) return 0;

        // Recursively compute the depth of the left subtree
        int left = maxDepth(node.left);

        // Recursively compute the depth of the right subtree
        int right = maxDepth(node.right);

        // The depth of the current node is the max of left and right subtree depths plus 1
        return Math.max(left, right) + 1;
    }

    @Test
    public void testMaxDepth() {
        // Construct the tree:
        //       1
        //      / \
        //     2   3
        //    /
        //   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        assertEquals(3, maxDepth(root));  // Depth is 3
        assertEquals(0, maxDepth(null));  // Empty tree
        assertEquals(1, maxDepth(new TreeNode(42)));  // Single node
    }

}
