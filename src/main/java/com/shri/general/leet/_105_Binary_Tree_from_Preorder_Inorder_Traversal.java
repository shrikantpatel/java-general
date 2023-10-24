package com.shri.general.leet;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 * 13.8K
 * 414
 * Companies
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class _105_Binary_Tree_from_Preorder_Inorder_Traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = null;

        root = buildTree(preorder, inorder, root, 0, 0, preorder.length - 1, false);
        return root;
    }

    /**
                                    1
                2                                       3
     4                    5                 6                        7
8       9             10                      11               12      13

     Inorder Travesal --> left subtree, root, right subtree and repeat (recursively)
     8, 4, 9, 2, 10, 5, 1, 6, 11, 3, 12, 7, 13

     Pre Order Travesal --> root, left subtree, right subtree and repeat (recursively)
     1, 2, 4, 8, 9, 5, 10, 3, 6, 11, 7, 12, 13

     Pattern is in case of InOrder Travesal, the root is the middle of array\sub array,
     all element to left are part of left tree,
     all element of the right of are part of the right tree

     Pattern is in case of Preorder Travesal, the first element of array \ sub array.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder, TreeNode parent, int startIndex_PreOrder, int startIndex_Inorder, int endIndex_Inorder, boolean leftChild) {

        TreeNode currentNode = new TreeNode(preorder[startIndex_PreOrder]);
        if (parent == null) parent = currentNode;
        else if (leftChild) parent.left = currentNode;
        else parent.right = currentNode;

        // using the inorder to get lenght of the left and right tree.
        int parentIndex_InInorder = indexOf(inorder, preorder[startIndex_PreOrder]);
        int lengthOfLeftTree = parentIndex_InInorder - startIndex_Inorder;
        int lengthOfRightTree = endIndex_Inorder - parentIndex_InInorder;

        // use the right and left sub arrays to determine the sub array that we need to recursively follow this process for.
        if (lengthOfLeftTree > 0)
            buildTree(preorder, inorder, currentNode, startIndex_PreOrder + 1, startIndex_Inorder, parentIndex_InInorder - 1, true);
        if (lengthOfRightTree > 0)
            buildTree(preorder, inorder, currentNode, startIndex_PreOrder + lengthOfLeftTree + 1, parentIndex_InInorder + 1, endIndex_Inorder, false);

        return parent;
    }

    public int indexOf(int[] array, int toFind) {
        if (array == null) return -1;

        int i = -1;
        for (int element : array) {
            if (element == toFind) {
                return ++i;
            }
            ++i;
        }
        return -1;
    }

    @Test
    public void test1() {
        _105_Binary_Tree_from_Preorder_Inorder_Traversal test = new _105_Binary_Tree_from_Preorder_Inorder_Traversal();
        test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
